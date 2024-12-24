package com.example.data.table

import org.jetbrains.exposed.sql.Table

object Tags : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    override val primaryKey = PrimaryKey(id)
}