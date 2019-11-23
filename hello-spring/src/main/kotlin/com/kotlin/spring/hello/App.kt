package com.kotlin.spring.hello

import com.kotlin.spring.hello.entity.People
import com.kotlin.spring.hello.repository.PeopleRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import java.util.*

@SpringBootApplication
class App {

    private val log = LoggerFactory.getLogger(App::class.java)

    @Autowired private lateinit var peopleRepository: PeopleRepository

    @EventListener
    fun ready(event: ApplicationReadyEvent) {
        val now = Date()
        peopleRepository.save(People(null, "Jason", "Chen", "Male", 28, now, now))
        peopleRepository.save(People(null, "Bluce", "Li", "Male", 32, now, now))
        peopleRepository.save(People(null, "Corey", "Chen", "Female", 20, now, now))

        for (people in peopleRepository.findAll()!!) {
            log.info(people.toString())
        }

        val customer = peopleRepository.findById(1L)
        log.info(customer.toString())
        for (chen in peopleRepository.findByLastName("Chen")!!) {
            log.info(chen.toString())
        }
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
