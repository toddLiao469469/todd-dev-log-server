package com.example.data.table

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Posts : Table("posts") {
    val id = integer("id").autoIncrement()
    val content = text("content")
    val createdAt = datetime("createdAt").clientDefault {
        LocalDateTime.now()
    }
    val updatedAt = datetime("updatedAt").clientDefault {
        LocalDateTime.now()
    }

    override val primaryKey = PrimaryKey(id)
}