package com.example.onlineshop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.callback.OnListenResponse
import com.example.onlineshop.helper.UserHelper
import com.example.onlineshop.repository.AuthenticationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private lateinit var repository: AuthenticationRepository
    fun setRepository(repository: AuthenticationRepository) {
        this.repository = repository
    }

    val loginState = MutableStateFlow<Boolean?>(null)


    fun register(firstName: String, lastName: String, email: String, password: String) {
        if (!UserHelper.validate(email, password))
            return
        val name = "$firstName $lastName"
        viewModelScope.launch {
            repository.requestSignUp(
                name = name,
                email = email,
                password = password,
                onListenResponse = object : OnListenResponse<Boolean> {
                    override fun onSuccess(data: Boolean?) {
                        println("RegisterViewModel onSuccess: $data")
                        loginState.value = data
                    }

                    override fun onFail(error: String) {
                        println(error)
                        loginState.value = null
                    }
                }
            )
        }
    }

}