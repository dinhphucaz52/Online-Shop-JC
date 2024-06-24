package com.example.onlineshop.data.api

import com.example.onlineshop.data.api.dto.ResponseDTO
import com.example.onlineshop.data.api.dto.UserDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("product")
    fun getProducts(): Call<ResponseDTO<List<UserDTO>>>

    @POST("user/sign-in")
    fun signIn(@Body body: HashMap<String, Any>): Call<ResponseDTO<UserDTO>>

    @POST("user/sign-up")
    fun signUp(@Body body: HashMap<String, Any>): Call<ResponseDTO<UserDTO>>

}