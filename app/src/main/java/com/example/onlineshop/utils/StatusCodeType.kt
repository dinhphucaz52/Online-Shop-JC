package com.example.onlineshop.utils

object StatusCodeType {
    fun isFailed(code: Int): Boolean {
        return code != SUCCESS
    }

    private const val SUCCESS = 200
}