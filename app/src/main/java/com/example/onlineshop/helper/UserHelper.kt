package com.example.onlineshop.helper

object UserHelper {
    fun validate(email: String, password: String): Boolean {
        val regex = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        return !(!regex.matches(email) || password.length < 8)
    }
}