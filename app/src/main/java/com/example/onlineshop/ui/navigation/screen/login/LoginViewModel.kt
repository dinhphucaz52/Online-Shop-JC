package com.example.onlineshop.ui.navigation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.data.repository.AuthRepositoryImpl
import com.example.onlineshop.utils.AppResource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {
    companion object {
        const val SUCCESS = "Success"
    }

    private lateinit var authRepository: AuthRepositoryImpl

    fun setRepository(repository: AuthRepositoryImpl) {
        this.authRepository = repository
    }

    val loginState = MutableStateFlow<String?>(null)
    val loadingState = MutableStateFlow(false)

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loadingState.value = true
            when (val result = authRepository.login(email, password)) {
                is AppResource.Success -> {
                    loginState.value = SUCCESS
                }

                is AppResource.Error -> {
                    loginState.value = result.error
                }
            }
            loadingState.value = false
        }
    }

}