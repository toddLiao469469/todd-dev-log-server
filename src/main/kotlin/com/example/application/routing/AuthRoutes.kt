package com.example.application.routing

import com.example.domain.model.LoginRequest
import com.example.domain.service.AuthService
import com.example.domain.service.UserService
import com.example.util.verifyPassword
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.authRoutes() {
    println("register authRoutes")
    route("/private") {
        route("/login") {
            post {
                val loginRequest = call.receive<LoginRequest>()

                val user = UserService.findByUsername(loginRequest.username)
                if (user == null || !verifyPassword(loginRequest.password, user.passwordHash)) {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid credentials")
                    return@post
                }

            }
        }
        route("/signup") {
            post {
                val signupRequest = call.receive<LoginRequest>()

                val result = AuthService.createUser(signupRequest.username, signupRequest.password)
                if (result.success) {
                    call.respond(HttpStatusCode.Created, result.message)
                } else {
                    call.respond(HttpStatusCode.BadRequest, result.message)
                }
            }
        }
    }
}

