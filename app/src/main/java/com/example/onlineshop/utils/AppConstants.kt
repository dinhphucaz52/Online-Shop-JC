package com.example.onlineshop.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.onlineshop.domain.model.Food

object AppConstants {
    // End point
    const val BASE_URL = "https://serverappsale.onrender.com/"

    // Time
    const val TIME_REQUEST_DEFAULT = 30L

    //Shared Preferences
    const val SHARED_PREFERENCES_NAME = "app_prefs"

    //Brush
    val myBrush = Brush.verticalGradient(
        listOf(
            Color(0xFFf3631c),
            Color(0xFFfbcf3b),
        )
    )
}