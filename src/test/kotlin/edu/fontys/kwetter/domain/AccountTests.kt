package edu.fontys.kwetter.domain

import edu.fontys.kwetter.repositories.AccountRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.context.junit4.SpringRunner
import javax.validation.ConstraintViolationException

@RunWith(SpringRunner::class)
@DataJpaTest
class AccountTests {
    @Autowired
    private lateinit var repository: AccountRepository

    @Test
    fun constructor() {
        val account = Account("DevNebulae", "Ivo Huntjens")
        repository.save(account)

        assertThat(repository.count()).isEqualTo(1)
    }

    @Test(expected = DataIntegrityViolationException::class)
    fun unique_handle() {
        val account1 = Account("DevNebulae", "Ivo Huntjens")
        val account2 = Account("DevNebulae", "Not Ivo Huntjens")

        repository.saveAll(listOf(account1, account2))

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun short_handle() {
        val account = Account("De", "")
        repository.save(account)

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun long_handle() {
        val account = Account("a".repeat(33), "Ivo Huntjens")
        repository.save(account)

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun blank_username() {
        val account = Account("DevNebulae", "     \r\n\t     ")
        repository.save(account)

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun long_username() {
        val account = Account("DevNebulae", "a".repeat(49))
        repository.save(account)

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun long_biography() {
        val account = Account("DevNebulae", "Ivo Huntjens")
        account.biography = "a".repeat(141)

        repository.save(account)

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun long_location() {
        val account = Account("DevNebulae", "Ivo Huntjens")
        account.location = "a".repeat(65)

        repository.save(account)

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun long_photourl() {
        val account = Account("DevNebulae", "Ivo Huntjens")
        account.photoURL = "a".repeat(65)

        repository.save(account)

        repository.findAll()
    }

    @Test(expected = ConstraintViolationException::class)
    fun long_websiteurl() {
        val account = Account("DevNebulae", "Ivo Huntjens")
        account.websiteURL = "a".repeat(65)

        repository.save(account)

        repository.findAll()
    }
}
