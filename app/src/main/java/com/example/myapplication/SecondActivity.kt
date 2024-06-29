package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.request.UserRequest
import com.example.myapplication.model.response.UserResponse
import com.example.myapplication.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        APIClient.getRetrofitInstance().createUsers(
            userRequest = UserRequest(
                name    = "Sid",
                email   = "sid@google.com",
                gender  = "Male",
                status  = "active")
        ).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response : Response<UserResponse>) {
                if (response.isSuccessful){
                    val body = response.body()

                    println(body?.name)
                }
                

            }

            override fun onFailure(p0: Call<UserResponse>, p1: Throwable) {
                println(p1.stackTrace)
            }

        })

/*
        APIClient.getRetrofitInstance().getPosts().enqueue(object : Callback<List<PostResponseItem>>{
            override fun onResponse(p0: Call<List<PostResponseItem>>, p1: Response<List<PostResponseItem>>) {
                if (p1.isSuccessful){
                    val response = p1.body()
                    response?.forEach {
                        //println(it.id)
                        //println(it.body)

                    }

                }
            }

            override fun onFailure(p0 : Call<List<PostResponseItem>>, p1: Throwable) {
                println(p1.stackTrace)
                println(p1.message)
                //TODO("Not yet implemented")
            }

        })


 */
    }
}