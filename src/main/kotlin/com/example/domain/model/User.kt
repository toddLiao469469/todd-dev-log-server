package com.example.domain.model

import org.jetbrains.exposed.dao.id.EntityID

data class User(
    val id: EntityID<Int>,
    val username: String,
    val passwordHash: String
)