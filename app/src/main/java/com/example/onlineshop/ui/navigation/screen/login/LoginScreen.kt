package com.example.onlineshop.ui.navigation.screen.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlineshop.R
import com.example.onlineshop.ui.component.BoldTextComponent
import com.example.onlineshop.ui.component.MyButton
import com.example.onlineshop.ui.component.MyTextField
import com.example.onlineshop.ui.component.NormalTextComponent
import com.example.onlineshop.ui.component.PasswordTextField

@Composable
fun LoginScreen(
    viewModel: LoginViewModel, onLoginSuccess: () -> Unit, navigateToRegister: () -> Unit
) {
    val loginResult by viewModel.loginState.collectAsState()
    val loading by viewModel.loadingState.collectAsState()


    if (loginResult == LoginViewModel.SUCCESS) {
        Toast.makeText(LocalContext.current, "Login Success", Toast.LENGTH_SHORT).show()
        onLoginSuccess()
    } else {
        if (loginResult?.isNotBlank() == true) {
            TODO()
//            Toast.makeText(LocalContext.current, "Error: $loginResult", Toast.LENGTH_SHORT).show()
        }
    }
    val myBrush = Brush.verticalGradient(
        listOf(
            Color(0xFFf9f7ea), Color(0xFFf5a3a8)
        )
    )
    Surface(
        color = Color.White, modifier = Modifier
            .fillMaxSize()
            .background(
                brush = myBrush
            )
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = myBrush
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NormalTextComponent(
                value = "Hey there,", modifier = Modifier.fillMaxWidth()
            )
            BoldTextComponent(
                value = "Welcome Back", modifier = Modifier.fillMaxWidth()
            )

            val email = remember { mutableStateOf("dinh.phuc.17.5.25@gmail.com") }
            val password = remember { mutableStateOf("00000000") }

            MyTextField(
                valueLabel = "Email",
                modifier = Modifier.fillMaxWidth(),
                painterResource = painterResource(id = R.drawable.ic_mail),
                textValue = email
            )
            PasswordTextField(
                modifier = Modifier.fillMaxWidth(), textValue = password
            )
            MyButton(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                text = "Login",
            ) {
                viewModel.login(email.value, password.value)
            }
            Text(text = "Don't have an account? Sign up",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clickable {
                        navigateToRegister()
                    })
            if (loading) {
                Spacer(modifier = Modifier.height(16.dp))
                CircularProgressIndicator()
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(viewModel = LoginViewModel(), onLoginSuccess = {}, navigateToRegister = {})
}