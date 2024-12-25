package com.example.domain.service

import com.example.domain.model.CreateUserResult
import com.example.infrastructure.repo.UserRepo
import com.example.util.hashPassword


object AuthService {
    fun createUser(username: String, password: String): CreateUserResult {
        return try {
            require(username.isNotBlank()) { "Username cannot be blank" }
            require(password.length >= 8) { "Password must be at least 8 characters long" }

            if (UserRepo.findByUsername(username) != null) {
                return CreateUserResult(false, "User already exists")
            }

            val passwordHash = hashPassword(password)
            UserRepo.createUser(username, passwordHash)
            CreateUserResult(true, "User created successfully")
        } catch (e: Exception) {
            CreateUserResult(false, "Error: ${e.message}")
        }
    }
}