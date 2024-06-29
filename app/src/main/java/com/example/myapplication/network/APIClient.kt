package com.example.myapplication.network

import com.example.myapplication.BASEURL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIClient {

    // https://medium.com/@imkuldeepsinghrai/api-calls-with-retrofit-in-android-kotlin-a-comprehensive-guide-e049e19deba9
    // https://medium.com/@pritam.karmahapatra/retrofit-in-android-with-kotlin-9af9f66a54a8
    fun getRetrofitInstance() : APIServices{


        //TODO("Make sure this log is always in DEBUG BUILD VARIANT")
        //Currently not added in DEBUG BUILD
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()



        val retrofit =  Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(APIServices::class.java)

    }

}

