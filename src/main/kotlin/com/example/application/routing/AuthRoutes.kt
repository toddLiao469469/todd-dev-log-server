package com.example.application.routing

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.config.EnvConfig
import com.example.domain.model.LoginRequest
import com.example.domain.service.AuthService
import com.example.domain.service.UserService
import com.example.util.verifyPassword
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*


fun Route.authRoutes() {
    route("/api/auth") {
        route("/login") {
            post {
                val loginRequest = call.receive<LoginRequest>()

                val user = UserService.findByUsername(loginRequest.username)
                if (user == null || !verifyPassword(loginRequest.password, user.passwordHash)) {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid credentials")
                    return@post
                }
                val token = JWT.create()
                    .withAudience(EnvConfig.jwtAudience)
                    .withIssuer(EnvConfig.jwtIssuer)
                    .withClaim("username", user.username)
                    .withExpiresAt(Date(System.currentTimeMillis() + (3600_000 * 24)))
                    .sign(Algorithm.HMAC256(EnvConfig.jwtSecret))

                call.respond(mapOf("token" to token))
            }
        }
        route("/signup") {
            post {
                val signupRequest = call.receive<LoginRequest>()

                val result = AuthService.createUser(signupRequest.username, signupRequest.password)
                if (result.success) {
                    call.respond(HttpStatusCode.Created, mapOf("result" to result.message))
                } else {
                    call.respond(HttpStatusCode.BadRequest, mapOf("error" to result.message))
                }
            }
        }
    }


}

