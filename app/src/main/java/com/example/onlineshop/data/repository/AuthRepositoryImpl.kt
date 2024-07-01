package com.example.onlineshop.data.repository

import com.example.onlineshop.data.dto.ResponseDTO
import com.example.onlineshop.data.dto.UserDTO
import com.example.onlineshop.data.local.SharedPreferencesManager
import com.example.onlineshop.data.remote.ApiService
import com.example.onlineshop.data.remote.RetrofitClient
import com.example.onlineshop.domain.repository.AuthRepository
import com.example.onlineshop.utils.AppResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthRepositoryImpl : AuthRepository {

    private val apiService: ApiService by lazy {
        RetrofitClient.getApiService()
    }

    fun saveUser(userDTO: UserDTO) {
        SharedPreferencesManager.saveUser(userDTO)
    }

    fun getUserToken(): String? {
        return SharedPreferencesManager.getUserToken()
    }


    override suspend fun login(email: String, password: String): AppResource<UserDTO> {
        return suspendCoroutine { continuation ->
            val hashMap = HashMap<String, Any>().apply {
                put("email", email)
                put("password", password)
            }

            apiService.signIn(hashMap).enqueue(object : Callback<ResponseDTO<UserDTO>> {
                override fun onResponse(
                    call: Call<ResponseDTO<UserDTO>>,
                    response: Response<ResponseDTO<UserDTO>>
                ) {
                    if (response.isSuccessful) {
                        val userDTO = response.body()?.data
                        if (userDTO != null) {
                            continuation.resume(AppResource.Success(userDTO))
                            saveUser(userDTO)
                        } else {
                            continuation.resume(AppResource.Error("User data is null"))
                        }
                    } else {
                        val errorMessage = response.errorBody()?.string()
                        continuation.resume(AppResource.Error(errorMessage ?: "Unknown error"))
                    }
                }

                override fun onFailure(call: Call<ResponseDTO<UserDTO>>, t: Throwable) {
                    continuation.resume(AppResource.Error(t.message ?: "Network error"))
                }
            })

        }
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): AppResource<UserDTO> {
        return suspendCoroutine { continuation ->
            val hashMap = HashMap<String, Any>().apply {
                put("email", email)
                put("name", name)
                put("password", password)
                put("phone", "0000000000")
                put("address", "Empty")
            }

            apiService.signUp(hashMap).enqueue(object : Callback<ResponseDTO<UserDTO>> {
                override fun onResponse(
                    call: Call<ResponseDTO<UserDTO>>,
                    response: Response<ResponseDTO<UserDTO>>
                ) {
                    if (response.isSuccessful) {
                        val userDTO = response.body()?.data
                        if (userDTO != null) {
                            continuation.resume(AppResource.Success(userDTO))
                        } else {
                            continuation.resume(AppResource.Error("Response body is null"))
                        }
                    } else {
                        val errorMessage = response.errorBody()?.string()
                        continuation.resume(AppResource.Error(errorMessage ?: "Unknown error"))
                    }
                }

                override fun onFailure(call: Call<ResponseDTO<UserDTO>>, t: Throwable) {
                    continuation.resume(AppResource.Error(t.message ?: "Network error"))
                }
            })
        }
    }

}