package com.example.onlineshop.domain.model

import com.example.onlineshop.data.dto.FoodDTO

data class Food(
    val id: String,
    val name: String,
    val address: String,
    val price: Int,
    val img: String,
    val quantity: Int,
    val gallery: List<String>,
) {
    constructor(foodDTO: FoodDTO) : this(
        id = foodDTO.id,
        name = foodDTO.name,
        address = foodDTO.address,
        price = foodDTO.price,
        img = foodDTO.img,
        quantity = foodDTO.quantity,
        gallery = foodDTO.gallery,
    )

    constructor() : this("", "", "", 0, "", 0, emptyList())

    fun getAllImg(): List<String> {
        val list = mutableListOf<String>()
        list.add(img)
        list.addAll(gallery)
        return list
    }

}