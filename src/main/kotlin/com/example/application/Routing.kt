package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.ResultSet

fun testDatabase() {
    transaction {
        exec("SELECT * FROM posts") { resultSet: ResultSet ->
            while (resultSet.next()) {
                println(resultSet.getInt("id"))
                println(resultSet.getTimestamp("createdAt"))
                println(resultSet.getTimestamp("updatedAt"))
                println(resultSet.getString("content"))

            }
            println("Connected to database! ")

        }
    }
}

fun Application.configureRouting() {
    routing {
        get("/") {
            testDatabase()
            call.respondText("Hello World!")
        }
    }
}

