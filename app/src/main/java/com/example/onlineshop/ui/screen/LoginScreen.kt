package com.example.onlineshop.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onlineshop.R
import com.example.onlineshop.ui.component.BoldTextComponent
import com.example.onlineshop.ui.component.MyButton
import com.example.onlineshop.ui.component.MyTextField
import com.example.onlineshop.ui.component.NormalTextComponent
import com.example.onlineshop.ui.component.PasswordTextField
import com.example.onlineshop.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    val myBrush = Brush.verticalGradient(
        listOf(
            Color(0xFFf9f7ea),
            Color(0xFFf5a3a8)
        )
    )
    Surface(
        color = Color.White,
        modifier = Modifier
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
            verticalArrangement = Arrangement.Center
        ) {
            NormalTextComponent(
                value = "Hey there,", modifier = Modifier.fillMaxWidth()
            )
            BoldTextComponent(
                value = "Welcome Back", modifier = Modifier.fillMaxWidth()
            )

            val email = remember { mutableStateOf("dasdfasfdasdp@sfl.com") }
            val password = remember { mutableStateOf("000000000000") }

            MyTextField(
                valueLabel = "Email",
                modifier = Modifier.fillMaxWidth(),
                painterResource = painterResource(id = R.drawable.ic_mail),
                textValue = email
            )
            PasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                textValue = password
            )
            MyButton(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                text = "Login",
            ) {
                navController.navigate("main")
//                loginViewModel.login(
//                    email = email.value,
//                    password = password.value
//                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(NavController(context = LocalContext.current),LoginViewModel())
}