package com.example.onlineshop.ui.navigation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.data.repository.AuthRepositoryImpl
import com.example.onlineshop.domain.repository.AuthRepository
import com.example.onlineshop.helper.UserHelper
import com.example.onlineshop.utils.AppResource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    companion object {
        const val SUCCESS = "Success"
    }

    private lateinit var repository: AuthRepository
    fun setRepository(repository: AuthRepositoryImpl) {
        this.repository = repository
    }

    val registerState = MutableStateFlow<String?>(null)
    val loadingState = MutableStateFlow(false)

    fun register(firstName: String, lastName: String, email: String, password: String) {
        if (!UserHelper.validate(email, password))
            return
        val name = "$firstName $lastName"
        viewModelScope.launch {
            loadingState.value = true
            when (val result = repository.register(name, email, password)) {
                is AppResource.Success -> {
                    registerState.value = SUCCESS
                }

                is AppResource.Error -> {
                    registerState.value = result.error
                }
            }
            loadingState.value = false
        }
    }

}