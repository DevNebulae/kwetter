package edu.fontys.kwetter.domain

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Account(
        @get: Column(unique = true, length = 32)
        var handle: String,

        @get: NotBlank
        @get: Size(max = 48)
        var username: String,

        var password: String
) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    var biography: String? = null

    var location: String? = null

    var photoURL: String? = null

    var websiteURL: String? = null

    @ManyToMany(mappedBy = "following")
    val followers: MutableSet<Account> = mutableSetOf()

    @ManyToMany
    val following: MutableSet<Account> = mutableSetOf()
}