package com.example.onlineshop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.data.repository.AuthRepositoryImpl
import com.example.onlineshop.ui.navigation.screen.login.LoginScreen
import com.example.onlineshop.ui.navigation.screen.login.LoginViewModel
import com.example.onlineshop.ui.navigation.screen.register.RegisterScreen
import com.example.onlineshop.ui.navigation.screen.register.RegisterViewModel

@Composable
fun AuthNavigation(navigationHomeScreen: () -> Unit) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login")
        {
            val loginViewModel: LoginViewModel = viewModel()
            loginViewModel.setRepository(AuthRepositoryImpl())
            LoginScreen(
                loginViewModel,
                onLoginSuccess = {
                    navigationHomeScreen()
                },
                navigateToRegister = {
                    navController.navigate("register")
                }
            )
        }
        composable("register") {
            val registerViewModel: RegisterViewModel = viewModel()
            registerViewModel.setRepository(AuthRepositoryImpl())
            RegisterScreen(registerViewModel) {
                navController.navigate("login")
            }
        }
    }
}