package com.example.onlineshop.data.dto


import com.google.gson.annotations.SerializedName

data class FoodDTO(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("address") val address: String,
    @SerializedName("price") val price: Int,
    @SerializedName("img") val img: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("gallery") val gallery: List<String>,
    @SerializedName("date_created") val dateCreated: String,
    @SerializedName("date_updated") val dateUpdated: Any,
    @SerializedName("__v") val v: Int
)