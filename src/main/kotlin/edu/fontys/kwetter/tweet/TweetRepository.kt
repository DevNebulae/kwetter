package edu.fontys.kwetter.tweet

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

interface TweetRepository : JpaRepository<Tweet, Long> {
    fun findByAuthor(author: String): List<Tweet>
}
