package com.example.learningretrofit.repository.api.service

import com.example.learningretrofit.repository.api.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    fun getAllPosts(): Call<List<Post>>

    @GET("posts/{postId}")
    fun getSinglePost(@Path("postId")postId: String): Call<Post>

    @FormUrlEncoded
    @POST("posts")
    fun setSinglePost(@Body post: Post): Call<Post>

}