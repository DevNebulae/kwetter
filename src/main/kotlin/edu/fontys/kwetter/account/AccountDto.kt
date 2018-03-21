package edu.fontys.kwetter.account

import javax.validation.constraints.NotBlank

data class AccountDto(
        @field: NotBlank
        var handle: String,

        @field: NotBlank
        var username: String,

        @field: NotBlank
        var password: String
)
