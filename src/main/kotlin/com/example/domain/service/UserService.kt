package com.example.domain.service

import com.example.domain.model.User
import com.example.infrastructure.repo.UserRepo
import com.example.util.hashPassword

object UserService {
    fun findByUsername(username: String): User? {
        return UserRepo.findByUsername(username)
    }

  
}