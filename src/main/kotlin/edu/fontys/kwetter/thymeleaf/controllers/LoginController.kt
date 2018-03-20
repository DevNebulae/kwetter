package edu.fontys.kwetter.thymeleaf.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController {
    @GetMapping("/login")
    fun index(): String {
        return "login"
    }
}
