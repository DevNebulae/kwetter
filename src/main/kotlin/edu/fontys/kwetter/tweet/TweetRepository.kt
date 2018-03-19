package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.tweet.Tweet
import org.springframework.data.jpa.repository.JpaRepository

interface TweetRepository : JpaRepository<Tweet, Long>
