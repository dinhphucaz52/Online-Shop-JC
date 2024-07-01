package com.example.onlineshop.domain.repository

import com.example.onlineshop.data.dto.FoodDTO
import com.example.onlineshop.utils.AppResource

interface HomeRepository {
    suspend fun getFoods() : AppResource<List<FoodDTO>>
}