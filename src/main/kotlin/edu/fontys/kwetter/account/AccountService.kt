package edu.fontys.kwetter.account

import edu.fontys.kwetter.account.role.AccountRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService {
    @Autowired
    private lateinit var repository: AccountRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    fun follow(follower: Account, toBeFollowed: Account): Account {
        follower.following.add(toBeFollowed)
        toBeFollowed.followers.add(follower)

        return repository.save(follower)
    }

    fun register(dto: AccountDto): Account {
        repository.findByHandleIgnoreCase(dto.handle).ifPresent({ throw Error("Handle is already in use.") })

        val account = Account(dto.handle, dto.username, passwordEncoder.encode(dto.password))
        account.roles.add(AccountRole.USER)

        return repository.save(account)
    }
}
