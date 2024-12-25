package com.example.plugins

import org.jetbrains.exposed.sql.Database
import org.flywaydb.core.Flyway

object DatabaseConfig {
    fun connect() {

        val databaseUrl = System.getenv("DATABASE_URL") ?: throw IllegalStateException("DATABASE_URL is not set")
        val user = System.getenv("DATABASE_USER") ?: throw IllegalStateException("DATABASE_USER is not set")
        val password = System.getenv("DATABASE_PASSWORD") ?: throw IllegalStateException("DATABASE_PASSWORD is not set")
        Database.connect(
            url = databaseUrl,
            driver = "org.postgresql.Driver",
            user = user,
            password = password,
        )


        val flyway = Flyway.configure()
            .dataSource(databaseUrl, user, password)
            .load()

        flyway.migrate()

    }
}
