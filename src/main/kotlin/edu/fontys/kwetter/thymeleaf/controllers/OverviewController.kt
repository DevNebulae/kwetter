package edu.fontys.kwetter.thymeleaf.controllers

import edu.fontys.kwetter.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class OverviewController {
    @Autowired
    private lateinit var repository: AccountRepository

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("users", repository.findAll())

        return "index"
    }

    @GetMapping("/tweets/{id}")
    fun overview(@PathVariable("id") id: Long, model: Model): String {
        model.addAttribute("tweets", repository.getOne(id).tweets)

        return "overview"
    }
}