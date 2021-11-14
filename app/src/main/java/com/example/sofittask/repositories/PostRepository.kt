package com.example.sofittask.repositories

import com.example.sofittask.network.RetroService

class PostRepository(private val retroService: RetroService) {
    fun getAllPosts() = retroService.getAllPosts()
}