package com.example.myapplication.model.request


import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String
)