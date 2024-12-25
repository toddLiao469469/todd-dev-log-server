package com.example.domain.model

data class CreateUserResult(
    val success: Boolean,
    val message: String,
    val userId: Int? = null,
    val errorCode: String? = null
)

data class LoginRequest(
    val username: String,
    val password: String
)