package com.example.onlineshop.repository

import android.content.Context
import com.example.onlineshop.callback.OnListenResponse
import com.example.onlineshop.data.api.ApiService
import com.example.onlineshop.data.api.RetrofitClient
import com.example.onlineshop.data.api.dto.FoodDTO
import com.example.onlineshop.data.api.dto.ResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainRepository (
    context: Context
) {

    private val apiService: ApiService by lazy {
        RetrofitClient.getApiService()
    }

    fun requestGetFoods(
        onListenResponse: OnListenResponse<List<FoodDTO>>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.getProducts().enqueue(object : Callback<ResponseDTO<List<FoodDTO>>> {
                override fun onResponse(
                    call: Call<ResponseDTO<List<FoodDTO>>>,
                    response: Response<ResponseDTO<List<FoodDTO>>>
                ) {
                    //Success
                    if (response.isSuccessful && response.body() != null) {
                        val list = response.body()?.data
                        println("MainRepository onResponse: $list")
                        onListenResponse.onSuccess(list)
                    } else {
                        onListenResponse.onSuccess(null)
                        println("MainRepository onResponse: ${response.errorBody()}")
                    }

                }

                override fun onFailure(p0: Call<ResponseDTO<List<FoodDTO>>>, throwable: Throwable) {
                    onListenResponse.onFail(throwable.message.toString())
                    println("MainRepository onFailure: ${throwable.message}")
                }
            })
        }
    }
}