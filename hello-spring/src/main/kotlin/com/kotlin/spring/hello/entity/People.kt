package com.kotlin.spring.hello.entity

import java.util.*
import javax.persistence.*

@Entity
data class People(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val firstName: String?,
        val lastName: String?,
        val gender: String?,
        val age: Int?,
        val gmtCreated: Date,
        val gmtModified: Date
)