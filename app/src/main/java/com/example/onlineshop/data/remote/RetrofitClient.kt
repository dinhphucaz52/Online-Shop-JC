package com.example.onlineshop.data.remote

import com.example.onlineshop.utils.AppConstants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val retrofit: Retrofit = createRetrofit()
    private val apiService = retrofit.create(ApiService::class.java)

    private fun createRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(AppConstants.TIME_REQUEST_DEFAULT, TimeUnit.SECONDS)
            .readTimeout(AppConstants.TIME_REQUEST_DEFAULT, TimeUnit.SECONDS)
            .writeTimeout(AppConstants.TIME_REQUEST_DEFAULT, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    fun getRetrofit() = retrofit
    fun getApiService(): ApiService = apiService

}