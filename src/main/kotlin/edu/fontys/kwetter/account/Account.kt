package edu.fontys.kwetter.account

import edu.fontys.kwetter.tweet.Tweet
import org.hibernate.validator.constraints.NotBlank
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
class Account(
        @field: Column(unique = true)
        @field: NotBlank
        @field: Size(min = 3, max = 32)
        val handle: String,

        @field: NotBlank
        @field: Size(max = 48)
        val username: String,

        @field: NotBlank
        val password: String
) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    @Size(max = 140)
    var biography: String? = null

    @Size(max = 64)
    var location: String? = null

    @Size(max = 64)
    var photoURL: String? = null

    @Size(max = 64)
    var websiteURL: String? = null

    @ManyToMany(mappedBy = "following")
    val followers: MutableSet<Account> = mutableSetOf()

    @ManyToMany
    val following: MutableSet<Account> = mutableSetOf()

    @ManyToMany
    val liked: MutableSet<Tweet> = mutableSetOf()

    @OneToMany(mappedBy = "author")
    val tweets: MutableList<Tweet> = mutableListOf()
}
