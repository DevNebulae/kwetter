package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.account.Account
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Tweet(author: Account, content: String) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    @ManyToOne(optional = false)
    val author = author

    @NotBlank
    @Size(max = 140)
    val content = content

    @ManyToMany(mappedBy = "liked")
    val likes: MutableSet<Account> = mutableSetOf()
}
