package edu.fontys.kwetter.follower

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/accounts")
class FollowerController {
    @Autowired
    private lateinit var repository: FollowerRepository

    @PutMapping("/{id}/follow")
    fun follow(@PathVariable("id") id: String, principal: Principal): Follower {
        val follower = Follower(principal.name, id)
        return repository.save(follower)
    }
}
