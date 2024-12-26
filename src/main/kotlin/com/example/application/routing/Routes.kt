package com.example.application.routing

import io.ktor.server.routing.*

fun Route.registerRoute() {
    postsRoute()
    authRoutes()
}


