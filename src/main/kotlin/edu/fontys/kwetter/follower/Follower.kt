package edu.fontys.kwetter.follower

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(
        uniqueConstraints = [UniqueConstraint(columnNames = ["follower", "followed"])]
)
data class Follower(val follower: String, val followed: String) : Serializable {
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID()
}
