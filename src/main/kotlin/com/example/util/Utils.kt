package com.example.util

import at.favre.lib.crypto.bcrypt.BCrypt

fun hashPassword(password: String): String {
    return BCrypt.withDefaults().hashToString(12, password.toCharArray())
}

fun verifyPassword(plainPassword: String, hashedPassword: String): Boolean {
    val result = BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword)
    return result.verified
}