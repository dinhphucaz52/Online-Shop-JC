package com.example.onlineshop.domain.model

import com.example.onlineshop.data.dto.UserDTO

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