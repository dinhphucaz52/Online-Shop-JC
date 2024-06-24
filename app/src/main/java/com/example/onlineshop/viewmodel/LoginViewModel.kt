package com.example.onlineshop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.callback.OnListenResponse
import com.example.onlineshop.data.api.dto.UserDTO
import com.example.onlineshop.data.model.User
import com.example.onlineshop.helper.UserHelper
import com.example.onlineshop.repository.AuthenticationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class LoginViewModel(
) : ViewModel() {

    private lateinit var repository: AuthenticationRepository

    fun setRepository(repository: AuthenticationRepository) {
        this.repository = repository
    }

    val userState = MutableStateFlow<String?>(null)


    fun login(email: String, password: String) {
        if (!UserHelper.validate(email, password))
            return
        viewModelScope.launch {
            repository.requestSignIn(
                email = email,
                password = password,
                onListenResponse = object : OnListenResponse<UserDTO> {
                    override fun onSuccess(data: UserDTO?) {
                        val user = data?.let { User(it) }
                        println("LoginViewModel onSuccess: $user")
                        userState.value = user?.name
                    }

                    override fun onFail(error: String) {
                        println(error)
                        userState.value = null
                    }
                }
            )
        }
    }
}