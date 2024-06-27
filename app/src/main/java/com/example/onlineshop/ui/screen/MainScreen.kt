package com.example.onlineshop.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.onlineshop.ui.component.Category
import com.example.onlineshop.ui.component.Header
import com.example.onlineshop.ui.component.MySearchBar
import com.example.onlineshop.ui.component.RecyclerView
import com.example.onlineshop.viewmodel.MainViewModel


//@Composable
//fun MainScreen(
//    navController: NavController,
//    viewModel: MainViewModel
//) {
//    val myBrush = Brush.verticalGradient(
//        listOf(
//            Color(0xFFf3f4f8),
//            Color(0xFFf3f4f8),
//        )
//    )
//
//    LazyColumn(
//        modifier = Modifier
//            .background(
//                brush = myBrush
//            )
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        item { Header(modifier = Modifier.fillMaxWidth()) }
//        item { MySearchBar(modifier = Modifier.fillMaxWidth()) }
//        item {
//            RecyclerView(
//                viewModel.foodListState,
//                Modifier
//                    .padding(top = 10.dp)
//                    .fillMaxWidth()
//                    .height(500.dp),
//            )
//            Category(
//                modifier = Modifier
//                    .padding(top = 20.dp)
//            )
//        }
//        item {
//
//        }
//    }
//}

@Composable
fun MainScreen(
    navController: NavController,
) {
    val viewModel: MainViewModel = viewModel()
    println("MainScreen recompose :${viewModel.foodListState.value}")
    Column(
        modifier = Modifier
            .background(
                color = Color.White
            )
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(modifier = Modifier.fillMaxWidth())
        MySearchBar(modifier = Modifier.fillMaxWidth())
        RecyclerView(
            viewModel.foodListState,
            Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            navController.navigate("detail/$index")
        }
        Category(
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}

@Preview
@Composable
fun Preview() {
    MainScreen(navController = NavController(LocalContext.current))
}