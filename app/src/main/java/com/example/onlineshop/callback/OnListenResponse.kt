package com.example.onlineshop.callback

interface OnListenResponse<T> {
    fun onSuccess(data: T?)
    fun onFail(error: String)
}