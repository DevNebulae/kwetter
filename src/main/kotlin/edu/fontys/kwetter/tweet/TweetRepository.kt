package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.tweet.Tweet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "/tweets")
interface TweetRepository : JpaRepository<Tweet, Long>
