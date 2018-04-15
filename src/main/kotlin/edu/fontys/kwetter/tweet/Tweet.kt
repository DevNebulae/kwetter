package edu.fontys.kwetter.tweet

import edu.fontys.kwetter.account.Account
import org.hibernate.validator.constraints.NotBlank
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
class Tweet(
        @field: NotBlank
        @field: Size(max = CHARACTER_LIMIT)
        val content: String,

        author: String?
) : Serializable {
    @Id
    @GeneratedValue
    val id: Long = 0

    @NotNull
    val author = author

    val likes: MutableSet<String> = mutableSetOf()
}
