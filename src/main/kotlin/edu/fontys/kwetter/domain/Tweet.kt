package edu.fontys.kwetter.domain

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
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
}
