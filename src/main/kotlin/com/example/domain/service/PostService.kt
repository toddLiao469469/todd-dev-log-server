package com.example.domain.service

import com.example.infrastructure.repo.PostRepo

class PostService {
    private val repository = PostRepo()

    fun getAllPosts() = repository.getAllPosts()

    fun createPost(content: String) {
        repository.insertPost(content)
    }
}
