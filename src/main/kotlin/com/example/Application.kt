package com.example

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.application.routing.registerRoute
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun Application.module() {
    configureSecurity()
    configureNegotiation()

    routing {
        registerRoute()
    }

    DatabaseConfig.connect()
}

fun Application.configureNegotiation() {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            },
        )
    }
}

fun Application.configureSecurity() {
    install(Authentication) {
        jwt {
            realm = "ktor-sample"
            verifier(
                JWT
                    .require(Algorithm.HMAC256("secret"))
                    .withAudience("ktor-audience")
                    .withIssuer("ktor-issuer")
                    .build()
            )
            validate { credential ->
                if (credential.payload.getClaim("username").asString() != null) {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
        }
    }
}