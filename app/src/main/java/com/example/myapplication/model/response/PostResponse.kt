package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName

data class PostResponse(
    val posts: List<PostResponseItem>
)

data class PostResponseItem(
    @SerializedName("body")
    val body: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("user_id")
    val user_id: Int
)