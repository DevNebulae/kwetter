package edu.fontys.kwetter.tweet

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource

@RepositoryRestResource(collectionResourceRel = "tweets", path = "/hateoas-tweets")
interface TweetRepository : JpaRepository<Tweet, Long> {
    fun findByAuthor(author: String): List<Tweet>
    fun findByAuthorIn(authors: List<String>): List<Tweet>

    @RestResource
    fun findByContentIgnoreCaseContaining(content: String, pageable: Pageable): Page<Tweet>
}
