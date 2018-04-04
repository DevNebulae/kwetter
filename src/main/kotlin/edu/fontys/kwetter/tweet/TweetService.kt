package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.account.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TweetService {
    @Autowired
    private lateinit var repository: TweetRepository

    fun post(author: Account, content: String): Tweet {
        return repository.save(Tweet(author, content))
    }
}
