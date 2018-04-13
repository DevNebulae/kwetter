package edu.fontys.kwetter.account

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(path = "/accounts")
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByHandle(handle: String): Optional<Account>
    fun findByHandleIgnoreCase(handle: String): Optional<Account>
}
