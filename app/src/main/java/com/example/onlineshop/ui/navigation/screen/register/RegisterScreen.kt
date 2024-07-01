package com.example.onlineshop.ui.navigation.screen.register

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.R
import com.example.onlineshop.ui.component.BoldTextComponent
import com.example.onlineshop.ui.component.MyButton
import com.example.onlineshop.ui.component.MyTextField
import com.example.onlineshop.ui.component.PasswordTextField


@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel,
    onRegisterSuccess: () -> Unit
) {

    val registerResult by registerViewModel.registerState.collectAsState()
    val loading by registerViewModel.loadingState.collectAsState()

    if (registerResult == RegisterViewModel.SUCCESS) {
        Toast.makeText(LocalContext.current, "Register Success", Toast.LENGTH_SHORT).show()
        onRegisterSuccess()
    } else {
        if (registerResult?.isNotBlank() == true) {
            TODO()
//            Toast.makeText(LocalContext.current, "Error: $registerResult", Toast.LENGTH_SHORT).show()
        }
    }

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
            Text(
                text = "Register",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
            )
            BoldTextComponent(
                value = "", modifier = Modifier.fillMaxWidth()
            )

            val firstName = remember { mutableStateOf("Nguyen Dinh") }
            val lastName = remember { mutableStateOf("Phuc") }
            val email = remember { mutableStateOf("dasdfasfdasdp@sfl.com") }
            val password = remember { mutableStateOf("000000000000") }

            MyTextField(
                valueLabel = "First Name",
                modifier = Modifier.fillMaxWidth(),
                painterResource = painterResource(id = R.drawable.ic_user), textValue = firstName
            )
            MyTextField(
                valueLabel = "Last Name",
                modifier = Modifier.fillMaxWidth(),
                painterResource = painterResource(id = R.drawable.ic_user),
                textValue = lastName
            )
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
                text = "Register",
            ) {
                registerViewModel.register(
                    firstName = firstName.value,
                    lastName = lastName.value,
                    email = email.value,
                    password = password.value
                )
            }
            if (loading) {
                Spacer(modifier = Modifier.height(16.dp))
                CircularProgressIndicator()
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(RegisterViewModel()) {

    }
}