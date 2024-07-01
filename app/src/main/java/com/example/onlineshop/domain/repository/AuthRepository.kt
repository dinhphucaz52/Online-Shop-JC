package com.example.onlineshop.domain.repository

import com.example.onlineshop.data.dto.UserDTO
import com.example.onlineshop.utils.AppResource

interface AuthRepository {
    suspend fun login(email: String, password: String): AppResource<UserDTO>
    suspend fun register(name: String, email: String, password: String): AppResource<UserDTO>
}