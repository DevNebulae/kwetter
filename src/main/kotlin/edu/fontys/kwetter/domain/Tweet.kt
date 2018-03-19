package edu.fontys.kwetter.domain

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Tweet(
        @get: NotBlank
        @get: Size(max = 140)
        val content: String
) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    @ManyToOne(optional = false)
    lateinit var author: Account;

    @ManyToMany(mappedBy = "liked")
    val likes: MutableSet<Account> = mutableSetOf()
}
