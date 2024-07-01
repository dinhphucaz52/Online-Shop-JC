package com.example.onlineshop.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.data.local.SharedPreferencesManager
import com.example.onlineshop.ui.navigation.MainNavigation
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPreferencesManager.init(this)

        setContent {
            MainNavigation()
        }
    }
}