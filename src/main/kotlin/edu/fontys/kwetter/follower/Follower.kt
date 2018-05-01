package edu.fontys.kwetter.follower

import java.io.Serializable
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id

data class Follower(val follower: String, val followed: String) : Serializable {
    @Id
    @GeneratedValue
    lateinit var id: UUID
}
