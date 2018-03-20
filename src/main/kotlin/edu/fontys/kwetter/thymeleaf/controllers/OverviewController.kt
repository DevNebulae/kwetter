package edu.fontys.kwetter.thymeleaf.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class OverviewController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}