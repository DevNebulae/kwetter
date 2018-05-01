package edu.fontys.kwetter.tweet

import org.springframework.data.jpa.repository.JpaRepository

interface TweetRepository : JpaRepository<Tweet, Long> {
    fun findByAuthor(author: String): List<Tweet>
}
