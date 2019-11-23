package com.kotlin.spring.hello.controller

import com.kotlin.spring.hello.service.PeopleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PeopleController @Autowired constructor(private val peopleService: PeopleService) {

    @GetMapping(value = ["/hello"])
    @ResponseBody
    fun hello(@RequestParam(value = "lastName") lastName: String): Any {
        val peoples = peopleService.findByLastName(lastName)
        val map = HashMap<Any, Any>()
        map["People last name is $lastName"] = peoples

        return map
    }
}