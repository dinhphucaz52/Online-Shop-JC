package com.example.onlineshop.utils

interface OnListenResponse<T> {
    fun onSuccess(data: T?)
    fun onFail(error: String)
}