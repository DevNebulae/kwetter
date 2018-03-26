package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.account.Account
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Tweet(
        @field: ManyToOne(optional = false)
        val author: Account,

        @field: NotBlank
        @field: Size(max = 140)
        val content: String
) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    @ManyToMany(mappedBy = "liked")
    val likes: MutableSet<Account> = mutableSetOf()
}
