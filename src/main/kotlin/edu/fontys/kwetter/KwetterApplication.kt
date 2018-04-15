package edu.fontys.kwetter

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KwetterApplication

fun main(args: Array<String>) {
    SpringApplication.run(KwetterApplication::class.java, *args)
}
