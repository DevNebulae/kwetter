package edu.fontys.kwetter.account

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class AccountRole(val title: String) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    @ManyToMany
    val accounts: MutableSet<Account> = mutableSetOf()
}
