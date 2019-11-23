package com.kotlin.spring.hello.service

import com.kotlin.spring.hello.entity.People
import com.kotlin.spring.hello.repository.PeopleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PeopleService @Autowired constructor(private val peopleRepository: PeopleRepository) {

    fun findByLastName(lastName: String): List<People> {
        return peopleRepository.findByLastName(lastName)
    }
}