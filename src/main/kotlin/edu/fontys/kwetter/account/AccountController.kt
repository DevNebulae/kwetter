package edu.fontys.kwetter.account

import org.keycloak.admin.client.Keycloak
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController {
    @Autowired
    private lateinit var keycloak: Keycloak

    @GetMapping("/{id}")
    fun getAccount(@PathVariable("id") id: String): AccountDto {
        val user = keycloak.realm("kwetter").users().get(id).toRepresentation()
        return AccountDto(user.id, user.username, user.isEnabled, user.firstName, user.lastName)
    }
}
