package edu.fontys.kwetter.tweet

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/tweets")
class TweetController {
    @Autowired
    private lateinit var repository: TweetRepository

    @GetMapping("/character-limit")
    fun characterLimit(): Int {
        return CHARACTER_LIMIT
    }

    @GetMapping("/timeline")
    fun timeline(principal: Principal): List<Tweet> {
        return repository.findByAuthor(principal.name)
    }

    @GetMapping("/timeline/{accountId}")
    fun timelineAccount(@PathVariable("accountId") accountId: String): List<Tweet> {
        return repository.findByAuthor(accountId)
    }

    @PostMapping
    fun postTweet(principal: Principal, @RequestBody tweet: Tweet): Tweet {
        val tweet = Tweet(tweet.content, principal.name)
        return repository.save(tweet)
    }
}
