package com.example.onlineshop.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.callback.OnListenResponse
import com.example.onlineshop.data.api.dto.FoodDTO
import com.example.onlineshop.data.model.Food
import com.example.onlineshop.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {

    val foodListState = mutableStateOf<List<Food>?>(null)

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            repository.requestGetFoods(
                object : OnListenResponse<List<FoodDTO>> {
                    override fun onSuccess(data: List<FoodDTO>?) {
                        if (data.isNullOrEmpty())
                            return
                        val result = List(data.size) { index ->
                            Food(
                                data[index].id,
                                data[index].name,
                                data[index].address,
                                data[index].price,
                                data[index].img,
                                data[index].quantity,
                                data[index].gallery,
                            )
                        }
                        SharedData.setFoodList(result)
                        foodListState.value = result
                    }
                    override fun onFail(error: String) {
                        foodListState.value = null
                    }
                }

            )
        }
    }
}