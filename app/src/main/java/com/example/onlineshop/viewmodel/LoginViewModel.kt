package com.example.onlineshop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.callback.OnListenResponse
import com.example.onlineshop.data.api.dto.UserDTO
import com.example.onlineshop.helper.UserHelper
import com.example.onlineshop.repository.AuthenticationRepository
import kotlinx.coroutines.launch


class LoginViewModel(
    private val repository: AuthenticationRepository
) : ViewModel() {

    fun login(email: String, password: String, onListenResponse: OnListenResponse<String>) {
        if (!UserHelper.validate(email, password))
            return
        viewModelScope.launch {
            repository.requestSignIn(
                email = email,
                password = password,
                onListenResponse = object : OnListenResponse<UserDTO> {
                    override fun onSuccess(data: UserDTO?) {
                        onListenResponse.onSuccess("Login successful")
                    }

                    override fun onFail(error: String) {
                        onListenResponse.onFail("Login failed")
                    }
                }
            )
        }
    }
}