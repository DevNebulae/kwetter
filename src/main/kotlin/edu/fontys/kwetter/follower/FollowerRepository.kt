package edu.fontys.kwetter.follower

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FollowerRepository : JpaRepository<Follower, UUID> {
    fun findByFollowed(followed: String): List<Follower>
    fun findByFollower(follower: String): List<Follower>
    fun findByFollowedAndFollower(followed: String, follower: String): Follower
}
