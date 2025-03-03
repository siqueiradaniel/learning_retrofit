package com.example.learningretrofit.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningretrofit.repository.api.client.ClientRetrofit
import com.example.learningretrofit.repository.api.model.Post
import com.example.learningretrofit.repository.api.service.PostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostVM: ViewModel() {
    private var postVM = MutableLiveData<Post>()

    fun getPostVM(): LiveData<Post> = postVM

    fun requestPost(id: String) {
        val postService = ClientRetrofit.createService(PostService::class.java)
        val post: Call<Post> = postService.getSinglePost(id)

        post.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                postVM.value = response.body()
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                postVM.value = null
            }
        })
    }
}