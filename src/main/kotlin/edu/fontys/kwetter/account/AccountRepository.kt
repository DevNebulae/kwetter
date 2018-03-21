package edu.fontys.kwetter.account

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountRepository : JpaRepository<Account, Long> {
    fun findByHandle(handle: String): Optional<Account>
}
