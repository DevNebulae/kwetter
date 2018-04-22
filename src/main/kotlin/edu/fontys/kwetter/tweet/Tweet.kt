package edu.fontys.kwetter.tweet

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import edu.fontys.kwetter.account.Account
import edu.fontys.kwetter.conversion.InstantConverter
import org.hibernate.validator.constraints.NotBlank
import java.io.Serializable
import java.time.Instant
import java.time.ZonedDateTime
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

    @ManyToMany(mappedBy = "liked")
    val likes: MutableSet<Account> = mutableSetOf()

    @Convert(converter = InstantConverter::class)
    val postedAt = Instant.now()
}
