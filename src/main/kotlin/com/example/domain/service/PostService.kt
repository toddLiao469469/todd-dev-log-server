package com.example.domain.service

import com.example.infrastructure.repo.PostRepo

class PostService {


    fun getAllPosts() = PostRepo.getAllPosts()

    fun createPost(content: String) {
        PostRepo.insertPost(content)
    }
}
