package com.example.learningretrofit.repository.api.model

import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""
}