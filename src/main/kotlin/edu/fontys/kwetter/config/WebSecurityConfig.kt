package edu.fontys.kwetter.config

import edu.fontys.kwetter.account.authentication.AccountDetailService
import edu.fontys.kwetter.account.role.AccountRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI


@Configuration
@EnableWebSecurity
class WebSecurityConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun webSecurityConfigurer(@Value("\${keycloak-client.realm}") realm: String): WebSecurityConfigurerAdapter {
        return object : WebSecurityConfigurerAdapter() {
            public override fun configure(http: HttpSecurity) {
                http
                        .csrf()
                        .disable()

                http
                        .authorizeRequests()
                        .anyRequest()
                        .authenticated()
                        .and()
                        // This is the point where OAuth2 login of Spring 5 gets enabled
                        .oauth2Login()
                        // I don't want a page with different clients as login options
                        // So i use the constant from OAuth2AuthorizationRequestRedirectFilter
                        // plus the configured realm as immediate redirect to Keycloak
                        .loginPage("$DEFAULT_AUTHORIZATION_REQUEST_BASE_URI/$realm")
            }
        }
    }
}
