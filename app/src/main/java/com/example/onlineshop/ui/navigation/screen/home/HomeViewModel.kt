package com.example.onlineshop.ui.navigation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.data.repository.HomeRepositoryImpl
import com.example.onlineshop.domain.model.Food
import com.example.onlineshop.domain.repository.HomeRepository
import com.example.onlineshop.utils.AppResource
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private lateinit var homeRepository: HomeRepository

    fun setRepository(repository: HomeRepositoryImpl) {
        this.homeRepository = repository
    }

    val foodListState = mutableStateOf<List<Food>?>(null)

    fun getProducts() {
        viewModelScope.launch {
            when (val result = homeRepository.getFoods()) {
                is AppResource.Success -> {
                    result.data?.let { foodDTOList ->
                        if (foodDTOList.isEmpty()) {
                            return@launch
                        }
                        val foodList = foodDTOList.map { foodDTO ->
                            Food(
                                foodDTO.id,
                                foodDTO.name,
                                foodDTO.address,
                                foodDTO.price,
                                foodDTO.img,
                                foodDTO.quantity,
                                foodDTO.gallery
                            )
                        }
                        foodListState.value = foodList
                    }
                }

                is AppResource.Error -> {
                    println("HomeViewModel: Failed to get foods: ${result.error}")
                }
            }
        }
    }

}