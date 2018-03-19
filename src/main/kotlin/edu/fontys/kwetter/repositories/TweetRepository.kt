package edu.fontys.kwetter.repositories

import edu.fontys.kwetter.domain.Tweet
import org.springframework.data.jpa.repository.JpaRepository

interface TweetRepository : JpaRepository<Tweet, Long>
