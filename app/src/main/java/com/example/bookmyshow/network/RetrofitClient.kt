package com.example.bookmyshow.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    val baseUrl = "https://62da8276e56f6d82a7637d47.mockapi.io/api/"
    private var instance : Retrofit? = null

    @Synchronized
    fun getInstance(): Retrofit? {
        if (instance == null) {
            instance = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()
        }
        return instance;
    }

    fun getRetrofitApi() : NetworkApi? {
        return getInstance()?.create(NetworkApi::class.java)
    }

}
