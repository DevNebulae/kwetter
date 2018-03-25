package edu.fontys.kwetter.thymeleaf.controllers

import edu.fontys.kwetter.account.AccountDto
import edu.fontys.kwetter.account.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.context.request.WebRequest

@Controller
class LoginController {
    @Autowired
    private lateinit var accountService: AccountService

    @GetMapping("/login")
    fun index(): String {
        return "login"
    }

    @GetMapping("/register")
    fun register(model: Model): String {
        val dto = AccountDto("", "", "")
        model.addAttribute("account", dto)
        return "registration"
    }

    @PostMapping("/register")
    fun registerAccount(@ModelAttribute("account") dto: AccountDto): String {
        accountService.register(dto)

        return index()
    }
}
