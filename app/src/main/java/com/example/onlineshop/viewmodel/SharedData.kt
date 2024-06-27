package com.example.onlineshop.viewmodel

import com.example.onlineshop.data.model.Food

object SharedData {
    private var foodList: List<Food> = emptyList()

    fun getFoodById(id: String) = foodList.find { it.id == id }

    fun getFoodByIndex(index: Int): Food? {
        if (foodList.isEmpty() || index < 0 || index >= foodList.size)
            return null
        return foodList[index]
    }

    fun setFoodList(foodList: List<Food>) {
        this.foodList = foodList
    }
}