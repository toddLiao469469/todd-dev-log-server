package com.example.data.table

import org.jetbrains.exposed.dao.id.IntIdTable
import java.time.LocalDateTime
import org.jetbrains.exposed.sql.javatime.datetime

object Users : IntIdTable("users") {
    val username = varchar("username", 255).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val createdAt =
        datetime("created_at").clientDefault {
            LocalDateTime.now()
        }
}

