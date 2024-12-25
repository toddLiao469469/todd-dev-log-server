package com.example.infrastructure.repo

import com.example.data.table.Users
import com.example.domain.model.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object UserRepo {
    fun findByUsername(username: String): User? {
        return transaction {
            Users.select { Users.username eq username }
                .map {
                    User(
                        id = it[Users.id],
                        username = it[Users.username],
                        passwordHash = it[Users.passwordHash]
                    )
                }
                .singleOrNull()
        }
    }

    fun createUser(username: String, passwordHash: String): Int {
        return transaction {
            Users.insertAndGetId {
                it[Users.username] = username
                it[Users.passwordHash] = passwordHash
            }.value
        }
    }
}