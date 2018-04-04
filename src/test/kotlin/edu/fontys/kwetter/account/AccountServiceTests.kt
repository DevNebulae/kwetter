package edu.fontys.kwetter.account

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
class AccountServiceTests {
    @Autowired
    private lateinit var repository: AccountRepository

    @Autowired
    private lateinit var service: AccountService

    @Test
    @Transactional
    fun follow_unidirectional() {
        var a1 = repository.save(Account("DevNebulae", "DevNebulae", "test123"))
        var a2 = repository.save(Account("TestNebulae", "TestNebulae", "password123"))

        service.follow(a1, a2)

        assertThat(a1.followers.size).isEqualTo(0)
        assertThat(a1.following.size).isEqualTo(1)
        assertThat(a1.following.contains(a2))

        assertThat(a2.following.size).isEqualTo(0)
        assertThat(a2.followers.size).isEqualTo(1)
        assertThat(a2.followers.contains(a1))
    }

    @Test
    @Transactional
    fun follow_bidirectional() {
        var a1 = repository.save(Account("DevNebulae", "DevNebulae", "test123"))
        var a2 = repository.save(Account("TestNebulae", "TestNebulae", "password123"))

        service.follow(a1, a2)
        service.follow(a2, a1)

        assertThat(a1.followers.size).isEqualTo(1)
        assertThat(a1.followers.contains(a2)).isTrue()
        assertThat(a1.following.size).isEqualTo(1)
        assertThat(a1.following.contains(a2)).isTrue()

        assertThat(a2.followers.size).isEqualTo(1)
        assertThat(a2.followers.contains(a1)).isTrue()
        assertThat(a2.following.size).isEqualTo(1)
        assertThat(a2.following.contains(a1)).isTrue()
    }

    @Test
    @Transactional
    fun register() {
        service.register(AccountDto("DevNebulae", "DevNebulae", "test123"))

        assertThat(repository.count()).isEqualTo(1)
    }

    @Test(expected = Error::class)
    @Transactional
    fun register_duplicate_handle() {
        service.register(AccountDto("DevNebulae", "DevNebulae", "test123"))
        service.register(AccountDto("DevNebulae", "DevNebulae", "test123"))
    }
}
