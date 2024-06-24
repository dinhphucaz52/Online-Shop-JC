package com.example.onlineshop.data.model

import com.example.onlineshop.data.api.dto.UserDTO

data class User(
    val email: String?,
    val name: String?,
    val phone: String?,
    val token: String?,
) {
    constructor(userDTO: UserDTO) : this(
        userDTO.email,
        userDTO.name,
        userDTO.phone,
        userDTO.token
    )
}