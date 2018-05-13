package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.follower.FollowerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.*
import java.security.Principal
import org.springframework.messaging.simp.SimpMessagingTemplate
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/tweets")
class TweetController {
    @Autowired
    private lateinit var repository: TweetRepository

    @Autowired
    private lateinit var followerRepository: FollowerRepository

    @Autowired
    private lateinit var tweetRepository: TweetRepository

    @Autowired
    private lateinit var webSocket: SimpMessagingTemplate

    @GetMapping("/character-limit")
    fun characterLimit(): Int {
        return CHARACTER_LIMIT
    }

    @DeleteMapping("/{id}")
    fun deleteTweet(@PathVariable("id") id: Long, principal: Principal, response: HttpServletResponse) {
        val tweet = tweetRepository.findOne(id)

        if (tweet.author == principal.name) {
            tweetRepository.delete(tweet)
            webSocket.convertAndSend("/timeline.deletion", id)
        } else {
            response.sendError(403)
        }
    }

    @GetMapping("/timeline")
    fun timeline(principal: Principal): List<Tweet> {
        val following = followerRepository.findByFollower(principal.name)
        val tweets = tweetRepository.findByAuthorIn(following.map { it.followed }.plus(principal.name)).sortedByDescending { it.postedAt }
        return tweets
    }

    @GetMapping("/timeline/{accountId}")
    fun timelineAccount(@PathVariable("accountId") accountId: String): List<Tweet> {
        return repository.findByAuthor(accountId)
    }

    @GetMapping("/query")
    fun query(@RequestParam("content") query: String, pageable: Pageable): Page<Tweet> {
        val tweets = repository.findByContentIgnoreCaseContaining(query, pageable)

        return tweets
    }

    @PostMapping
    fun postTweet(principal: Principal, @RequestBody tweet: Tweet): Tweet {
        val savedTweet = repository.save(Tweet(tweet.content, principal.name))

        webSocket.convertAndSend("/timeline.addition", savedTweet)
        return savedTweet
    }
}
