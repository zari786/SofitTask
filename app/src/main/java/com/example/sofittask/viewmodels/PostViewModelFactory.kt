package com.example.sofittask.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sofittask.repositories.PostRepository
import java.lang.IllegalArgumentException

class PostViewModelFactory(private val postRepository: PostRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(postRepository) as T
        }else{
            throw IllegalArgumentException("unknown model class")
        }
    }
}