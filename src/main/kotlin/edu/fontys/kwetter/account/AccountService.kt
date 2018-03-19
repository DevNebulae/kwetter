package edu.fontys.kwetter.account

import edu.fontys.kwetter.account.Account
import edu.fontys.kwetter.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {
    @Autowired
    private lateinit var repository: AccountRepository

    fun follow(follower: Account, toBeFollowed: Account) {
        follower.following.add(toBeFollowed)
        toBeFollowed.followers.add(follower)

        repository.saveAll(listOf(follower, toBeFollowed))
    }
}