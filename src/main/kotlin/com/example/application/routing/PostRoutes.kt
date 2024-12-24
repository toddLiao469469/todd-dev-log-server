package com.example.application.routing


import com.example.domain.service.PostService
import io.ktor.http.*
import io.ktor.http.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

object PostRoutes {
    private val postService = PostService()


    fun registerRoutes(route: Route) {
        route.route("/posts") {
            get {
                val posts = postService.getAllPosts()
                call.respond(posts)
            }
        }
    }
}

