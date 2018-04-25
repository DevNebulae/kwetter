package edu.fontys.kwetter.account

data class AccountDto(
        val id: String,
        val username: String,
        val enabled: Boolean,
        val firstName: String,
        val lastName: String
)
