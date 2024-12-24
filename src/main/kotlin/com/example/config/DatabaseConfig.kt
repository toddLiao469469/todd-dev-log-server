package com.example.plugins

import io.github.cdimascio.dotenv.Dotenv
import org.jetbrains.exposed.sql.Database

object DatabaseConfig {
    fun connect() {
        val dotenv = Dotenv.load()
        val databaseUrl = dotenv["DATABASE_URL"] ?: throw IllegalStateException("DATABASE_URL is not set")
        val user = dotenv["DATABASE_USER"] ?: throw IllegalStateException("DATABASE_USER is not set")
        val password = dotenv["DATABASE_PASSWORD"] ?: throw IllegalStateException("DATABASE_PASSWORD is not set")
        Database.connect(
            url = databaseUrl,
            driver = "org.postgresql.Driver",
            user = user,
            password = password,
        )
    }
}