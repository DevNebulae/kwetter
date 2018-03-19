package edu.fontys.kwetter.domain

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Account(handle: String, username: String) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    @Column(unique = true, length = 32)
    var handle = handle

    @NotBlank
    @Size(max = 48)
    var username = username

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

    @OneToMany
    val tweets: MutableList<Tweet> = mutableListOf()
}
