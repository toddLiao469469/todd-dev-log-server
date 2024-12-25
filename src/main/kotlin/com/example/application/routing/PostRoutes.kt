package com.example.application.routing

import com.example.domain.service.PostService
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.listPostsRoute() {
    val postService = PostService()

    route("/posts") {
        get {
            val posts = postService.getAllPosts()
            call.respond(posts)
        }
    }
} 