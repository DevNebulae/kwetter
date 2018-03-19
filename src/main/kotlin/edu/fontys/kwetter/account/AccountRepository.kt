package edu.fontys.kwetter.account

import edu.fontys.kwetter.account.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>
