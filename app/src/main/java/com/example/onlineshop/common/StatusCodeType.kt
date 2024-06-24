package com.example.onlineshop.common

object StatusCodeType {
    fun isFailed(code: Int): Boolean {
        return code != SUCCESS
    }

    private const val SUCCESS = 200
}