package com.example.onlineshop.repository

import android.content.Context
import com.example.onlineshop.callback.OnListenResponse
import com.example.onlineshop.common.AppCommon
import com.example.onlineshop.common.StatusCodeType
import com.example.onlineshop.data.api.ApiService
import com.example.onlineshop.data.api.RetrofitClient
import com.example.onlineshop.data.api.dto.ResponseDTO
import com.example.onlineshop.data.api.dto.UserDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationRepository(
    context: Context
) {
    private val apiService: ApiService by lazy {
        RetrofitClient.getApiService()
    }

    private val sharedPreferences by lazy {
        context.getSharedPreferences(AppCommon.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun requestSignIn(
        email: String,
        password: String,
        onListenResponse: OnListenResponse<UserDTO>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val hashMap = HashMap<String, Any>().apply {
                put("email", email)
                put("password", password)
            }

            apiService.signIn(hashMap).enqueue(object : Callback<ResponseDTO<UserDTO>> {
                override fun onResponse(
                    call: Call<ResponseDTO<UserDTO>>,
                    response: Response<ResponseDTO<UserDTO>>
                ) {
                    if (response.isSuccessful && response.body() != null) { //Success
                        val userDTO = response.body()?.data
                        if (userDTO != null) {
                            onListenResponse.onSuccess(userDTO)
                            saveUser(userDTO)
                        }
                    } else if (response.errorBody() != null && StatusCodeType.isFailed(response.code())) {
                        val json = JSONObject(response.errorBody()?.string() ?: "{}")
                        val errorMessage = json.optString("message")
                        onListenResponse.onFail(errorMessage)
                    }
                }

                override fun onFailure(call: Call<ResponseDTO<UserDTO>>, t: Throwable) {
                    onListenResponse.onFail(t.message.toString())
                }

            })
        }
    }

    private fun saveUser(userDTO: UserDTO) {
        val editor = sharedPreferences.edit()
        editor.putString("email", userDTO.email)
        editor.putString("name", userDTO.name)
        editor.putString("phone", userDTO.phone)
        editor.putString("token", userDTO.token)
        editor.apply()
    }

    fun requestSignUp(
        name: String,
        email: String,
        password: String,
        onListenResponse: OnListenResponse<Boolean>
    ) {
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
                if (response.isSuccessful && response.body() != null) { //Success
                    println("RegisterRepository onResponse: ${response.body()}")
                    onListenResponse.onSuccess(true)
                } else {
                    val json = JSONObject(response.errorBody()?.string() ?: "{}")
                    val errorMessage = json.optString("message")
                    onListenResponse.onFail(errorMessage)
                }
            }

            override fun onFailure(p0: Call<ResponseDTO<UserDTO>>, throwable: Throwable) {
                println("RegisterRepository onFailure: ${throwable.message}")
                onListenResponse.onFail(throwable.message.toString())
            }

        })
    }
}