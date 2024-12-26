package com.example.config


object EnvConfig {

    val jwtSecret: String by lazy {
        System.getenv("JWT_SECRET") ?: throw IllegalStateException("JWT_SECRET is not set")
    }

    val jwtAudience: String by lazy {
        System.getenv("JWT_AUDIENCE") ?: throw IllegalStateException("JWT_AUDIENCE is not set")
    }

    val jwtIssuer: String by lazy {
        System.getenv("JWT_ISSUER") ?: throw IllegalStateException("JWT_ISSUER is not set")
    }

    val dbUrl: String by lazy {
        System.getenv("DATABASE_URL") ?: throw IllegalStateException("DB_URL is not set")
    }
    val dbUser: String by lazy {
        System.getenv("DATABASE_USER") ?: throw IllegalStateException("DB_USER is not set")
    }
    val dbPassword: String by lazy {
        System.getenv("DATABASE_PASSWORD") ?: throw IllegalStateException("DB_PASSWORD is not set")
    }

}