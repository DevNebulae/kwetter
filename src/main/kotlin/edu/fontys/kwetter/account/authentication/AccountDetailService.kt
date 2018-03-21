package edu.fontys.kwetter.account.authentication

import edu.fontys.kwetter.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountDetailService : UserDetailsService {
    @Autowired
    private lateinit var repository: AccountRepository

    @Transactional
    override fun loadUserByUsername(handle: String): UserDetails {
        val account = repository.findByHandle(handle)

        if (!account.isPresent)
            throw UsernameNotFoundException(handle)

        val acc = account.get()
        return User(acc.handle, acc.password, acc.roles.map { SimpleGrantedAuthority(it.toString()) })
    }
}
