package com.example.onlineshop.data.local


import android.content.Context
import android.content.SharedPreferences
import com.example.onlineshop.data.dto.UserDTO

object SharedPreferencesManager {
    private const val PREF_NAME = "app_prefs"
    private const val KEY_EMAIL = "email"
    private const val KEY_NAME = "name"
    private const val KEY_PHONE = "phone"
    private const val KEY_TOKEN = "token"

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveUser(userDTO: UserDTO) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_EMAIL, userDTO.email)
        editor.putString(KEY_NAME, userDTO.name)
        editor.putString(KEY_PHONE, userDTO.phone)
        editor.putString(KEY_TOKEN, userDTO.token)
        editor.apply()
    }

    fun getUserToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }
}
