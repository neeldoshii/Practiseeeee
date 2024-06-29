package com.example.myapplication.network

import com.example.myapplication.model.request.UserRequest
import com.example.myapplication.model.response.PostResponseItem
import com.example.myapplication.model.response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIServices {

    @GET("posts")
    fun getPosts() : Call <List<PostResponseItem>>


    // For wrapping the bearer token
    // https://stackoverflow.com/a/51745658
    @POST("users")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 7c04076f3f155a32e7bcb05a4643b3a6ed4b05c27a0bcc3b8449079904d25bd6"
    )
    fun createUsers(
        @Body userRequest : UserRequest
    ) : Call<UserResponse>
}