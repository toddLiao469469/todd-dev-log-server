package com.example.data.table

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Posts : Table("posts") {
    val id = integer("id").autoIncrement()
    val title = text("title")
    val content = text("content")
    val status = text("status")
    val authorId = text("author_id")
    val createdAt =
        datetime("created_at").clientDefault {
            LocalDateTime.now()
        }
    val updatedAt =
        datetime("updated_at").clientDefault {
            LocalDateTime.now()
        }

    override val primaryKey = PrimaryKey(id)
}
