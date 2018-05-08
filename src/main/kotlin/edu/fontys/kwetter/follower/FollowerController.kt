package edu.fontys.kwetter.follower

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/accounts")
class FollowerController {
    @Autowired
    private lateinit var repository: FollowerRepository

    @GetMapping("/followers-list")
    fun getAll(): List<Follower> {
        return repository.findAll()
    }

    @PostMapping("/{id}/follow")
    fun follow(@PathVariable("id") id: String, principal: Principal): Follower {
        val follower = Follower(principal.name, id)
        return repository.save(follower)
    }

    @PostMapping("/{id}/unfollow")
    fun unfollow(@PathVariable("id") id: String, principal: Principal) {
        val follower = repository.findByFollowedAndFollower(id, principal.name)
        repository.delete(follower.id)
    }

    @GetMapping("/{id}/followers")
    fun followers(@PathVariable("id") id: String): List<Follower> {
        return repository.findByFollowed(id)
    }

    @GetMapping("/{id}/following")
    fun following(@PathVariable("id") id: String): List<Follower> {
        return repository.findByFollower(id)
    }
}
