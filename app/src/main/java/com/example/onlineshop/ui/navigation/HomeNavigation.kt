package com.example.onlineshop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.data.repository.HomeRepositoryImpl
import com.example.onlineshop.domain.model.Food
import com.example.onlineshop.ui.navigation.detail.food.DetailScreen
import com.example.onlineshop.ui.navigation.detail.food.FoodViewModel
import com.example.onlineshop.ui.navigation.screen.home.HomeScreen
import com.example.onlineshop.ui.navigation.screen.home.HomeViewModel

@Composable
fun HomeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        var curFood: Food? = null
        composable("home")
        {
            val homeViewModel: HomeViewModel = viewModel()
            homeViewModel.setRepository(HomeRepositoryImpl())
            HomeScreen(homeViewModel) { food ->
                curFood = food
                navController.navigate("detail")
            }
        }
        composable("detail") {
            val foodViewModel: FoodViewModel = viewModel()
            DetailScreen(food = curFood, viewModel = foodViewModel)
        }
    }
}

@Preview
@Composable
fun HomeNavigationPreview() {
    HomeNavigation()
}
