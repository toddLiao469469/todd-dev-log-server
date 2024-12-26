package com.example.plugins

import com.example.config.EnvConfig
import org.jetbrains.exposed.sql.Database
import org.flywaydb.core.Flyway

object DatabaseConfig {
    fun connect() {
        Database.connect(
            url = EnvConfig.dbUrl,
            driver = "org.postgresql.Driver",
            user = EnvConfig.dbUser,
            password = EnvConfig.dbPassword,
        )

        val flyway = Flyway.configure()
            .dataSource(EnvConfig.dbUrl, EnvConfig.dbUser, EnvConfig.dbPassword)
            .load()

        flyway.migrate()

    }
}
