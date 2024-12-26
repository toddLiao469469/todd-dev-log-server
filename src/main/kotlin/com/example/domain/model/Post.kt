package com.example.domain.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int,
    val title: String,
    val content: String,
    val status: String,
    val authorId: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

@Serializable
data class PostWithTags(
    val id: Int,
    val title: String,
    val content: String,
    val status: String,
    val authorId: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val tags: List<String>,
)


data class CreatePostRequet(
    val title: String,
    val content: String,
    val authorId: String,
    val status: String,
)