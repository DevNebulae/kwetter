package edu.fontys.kwetter.follower

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FollowerRepository : JpaRepository<Follower, UUID>
