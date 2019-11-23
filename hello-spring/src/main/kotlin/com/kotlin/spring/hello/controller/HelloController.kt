package com.kotlin.spring.hello.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping(value = ["/helloworld", "/"])
    fun helloworld(): Any {
        return "Hello,World!"
    }
}