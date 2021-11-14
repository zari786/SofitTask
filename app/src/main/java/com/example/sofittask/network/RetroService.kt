package com.example.sofittask.network

import com.example.sofittask.models.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetroService {

    @GET("posts")
    fun getAllPosts():Call<List<Post>>

    companion object {
        fun getInstance(): RetroService {
            var retroService: RetroService? = null
            if (retroService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retroService = retrofit.create(RetroService::class.java)
            }
            return retroService!!
        }
    }
}