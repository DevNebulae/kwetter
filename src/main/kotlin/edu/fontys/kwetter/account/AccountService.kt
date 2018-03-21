package edu.fontys.kwetter.account

import edu.fontys.kwetter.account.role.AccountRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService {
    @Autowired
    private lateinit var repository: AccountRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    fun follow(follower: Account, toBeFollowed: Account) {
        follower.following.add(toBeFollowed)
        toBeFollowed.followers.add(follower)

        repository.saveAll(listOf(follower, toBeFollowed))
    }

    fun register(dto: AccountDto): Account {
        val account = Account(dto.handle, dto.username, passwordEncoder.encode(dto.password))
        account.roles.add(AccountRole.USER)

        return repository.save(account)
    }
}