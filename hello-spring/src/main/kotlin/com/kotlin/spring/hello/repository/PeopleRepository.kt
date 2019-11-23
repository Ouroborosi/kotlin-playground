package com.kotlin.spring.hello.repository

import com.kotlin.spring.hello.entity.People
import org.springframework.data.repository.CrudRepository

interface PeopleRepository: CrudRepository<People, Long> {

    fun findByLastName(lastName: String): List<People>
}