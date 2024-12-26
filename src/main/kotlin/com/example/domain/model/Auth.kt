package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserResult(
    val success: Boolean,
    val message: String,
    val userId: Int? = null,
    val errorCode: String? = null
)

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)