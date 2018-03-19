package edu.fontys.kwetter.repositories

import edu.fontys.kwetter.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>
