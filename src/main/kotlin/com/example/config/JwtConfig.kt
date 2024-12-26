package com.example.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

object JwtConfig {
    private val secret = EnvConfig.jwtSecret

    private val algorithm = Algorithm.HMAC256(secret)

    private val verifier = JWT.require(algorithm)
        .withAudience(EnvConfig.jwtAudience)
        .withIssuer(EnvConfig.jwtIssuer)
        .build()

    fun verifyToken(token: String): Boolean {
        return try {
            verifier.verify(token)
            true // Token 驗證成功
        } catch (e: Exception) {
            false // Token 驗證失敗
        }
    }
}