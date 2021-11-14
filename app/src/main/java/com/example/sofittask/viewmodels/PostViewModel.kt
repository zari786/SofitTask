package com.example.sofittask.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sofittask.repositories.PostRepository
import com.example.sofittask.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    var post = MutableLiveData<List<Post>>()
    var loading = MutableLiveData<Boolean>()
    var error = MutableLiveData<String>()


    fun getAllPosts() {
        loading.postValue(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val postService = postRepository.getAllPosts()
                postService.enqueue(object : Callback<List<Post>> {
                    override fun onResponse(
                        call: Call<List<Post>>,
                        response: Response<List<Post>>
                    ) {
                        loading.postValue(false)
                        if (response.isSuccessful) {
                            post.postValue(response.body())
                        }else{
                            error.postValue(response.errorBody().toString())
                        }
                    }

                    override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                        loading.postValue(false)
                        error.postValue(t.message)
                    }
                })
            }
        }
    }

}