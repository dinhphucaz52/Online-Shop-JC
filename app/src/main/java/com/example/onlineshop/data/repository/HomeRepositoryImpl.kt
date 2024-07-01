package com.example.onlineshop.data.repository

import com.example.onlineshop.data.dto.FoodDTO
import com.example.onlineshop.data.dto.ResponseDTO
import com.example.onlineshop.data.remote.ApiService
import com.example.onlineshop.data.remote.RetrofitClient
import com.example.onlineshop.domain.repository.HomeRepository
import com.example.onlineshop.utils.AppResource
import com.example.onlineshop.utils.OnListenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class HomeRepositoryImpl : HomeRepository {

    private val apiService: ApiService by lazy {
        RetrofitClient.getApiService()
    }

    override suspend fun getFoods(): AppResource<List<FoodDTO>> {
        return suspendCoroutine { continuation ->
            apiService.getFoods().enqueue(object : Callback<ResponseDTO<List<FoodDTO>>> {
                override fun onResponse(
                    call: Call<ResponseDTO<List<FoodDTO>>>,
                    response: Response<ResponseDTO<List<FoodDTO>>>
                ) {
                    if (response.isSuccessful) {
                        val foodDTOList = response.body()?.data
                        if (foodDTOList != null) {
                            continuation.resume(AppResource.Success(foodDTOList))
                        } else {
                            continuation.resume(AppResource.Error("Empty response body"))
                        }
                    } else {
                        val errorMessage = response.errorBody()?.string()
                        continuation.resume(AppResource.Error(errorMessage ?: "Unknown error"))
                    }
                }

                override fun onFailure(p0: Call<ResponseDTO<List<FoodDTO>>>, throwable: Throwable) {
                    continuation.resume(AppResource.Error(throwable.message ?: "Network error"))
                }
            })
        }
    }
}