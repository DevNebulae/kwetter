package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.account.Account
import edu.fontys.kwetter.account.AccountRepository
import edu.fontys.kwetter.tweet.TweetRepository
import edu.fontys.kwetter.tweet.Tweet
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class TweetTests {
    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Autowired
    private lateinit var tweetRepository: TweetRepository

    @Test
    fun constructor() {
        val account = accountRepository.save(Account("DevNebulae", "Ivo Huntjens"))
        val tweet = Tweet(account, "Works great, doesn't it?")

        tweetRepository.save(tweet)
        assertThat(tweetRepository.count()).isEqualTo(1)
    }
}
