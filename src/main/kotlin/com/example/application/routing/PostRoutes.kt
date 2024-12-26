package com.example.application.routing

import com.example.domain.service.PostService
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.postsRoute() {
    val postService = PostService()

    route("/api") {
        route("/posts") {
            get {
                val posts = postService.getAllPosts()
                call.respond(posts)
            }
        }

        route("/post") {
            get {

            }
        }
    }

    authenticate("auth-jwt") {
        route("/private") {
            route("/post") {
                post {
                    call.respond(mapOf("result" to "success"))
                }
            }
        }
    }

}
