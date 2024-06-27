package com.example.onlineshop.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.More
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DinnerDining
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FreeBreakfast
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LocalPizza
import androidx.compose.material.icons.filled.NoFood
import androidx.compose.material.icons.filled.PropaneTank
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.data.model.Food
import com.example.onlineshop.ui.theme.DarkColorScheme


@Composable
fun Header(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconModifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
        Icon(Icons.Default.History, null, iconModifier, DarkColorScheme.primary)
        Text(
            text = "Home",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = DarkColorScheme.primary
        )
        Icon(Icons.Filled.ShoppingCart, null, iconModifier, DarkColorScheme.primary)
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    )
}

@Composable
fun Item(painterResource: ImageVector, colorBackground: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(5.dp)
            .background(
                color = colorBackground, shape = RoundedCornerShape(10.dp)
            )
            .padding(5.dp), contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            imageVector = painterResource,
            contentDescription = null,
            tint = Color.White,
        )
    }
}

@Composable
fun Category(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Item(
                painterResource = Icons.Filled.FreeBreakfast,
                colorBackground = Color(0xFFf36186),
                Modifier.weight(1f)
            )
            Item(
                painterResource = Icons.Filled.Fastfood,
                colorBackground = Color(0xFFad74da),
                Modifier.weight(1f)
            )
            Item(
                painterResource = Icons.Filled.DinnerDining,
                colorBackground = Color(0xFFff9888),
                Modifier.weight(1f)
            )
            Item(
                painterResource = Icons.Filled.LocalPizza,
                colorBackground = Color(0xFF5ecd93),
                Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Item(
                painterResource = Icons.Filled.FavoriteBorder,
                colorBackground = Color(0xFFa078ea),
                Modifier.weight(1f)
            )
            Item(
                painterResource = Icons.Filled.NoFood,
                colorBackground = Color(0xFF8ed6ef),
                Modifier.weight(1f)
            )
            Item(
                painterResource = Icons.Filled.PropaneTank,
                colorBackground = Color(0xFF9893e4),
                Modifier.weight(1f)
            )
            Item(
                painterResource = Icons.AutoMirrored.Filled.More,
                colorBackground = Color(0xFFc471f3),
                Modifier.weight(1f)
            )
        }
    }

}


@Preview
@Composable
fun TestPreview(
) {
    Category(modifier = Modifier.height(100.dp))
}

@Composable
fun FoodItem(
    modifier: Modifier, food: Food, indexed: Int, onclick: () -> Unit
) {
//    println("$indexed recompose")
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White, shape = RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = "${food.price} VND",
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = DarkColorScheme.primary
        )
        Text(
            text = food.name,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .clickable {
                    onclick()
                },
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RecyclerView(list: MutableState<List<Food>?>, modifier: Modifier, onclick: (Int) -> Unit) {
    println("RecyclerView recompose")
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp)),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        val listFood = list.value ?: emptyList()
        itemsIndexed(listFood) { indexed, food ->
            FoodItem(modifier = Modifier, food = food, indexed) {
                onclick(indexed)
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun Preview() {
    val food = Food(
        "62b72b165e4e6e6e3c6a81e6",
        "A Chảy - Mì Sủi Cảo & Cơm Chiên Gà Xối Mỡ - Shop Online",
        "58/11 Nguyễn Văn Săng, P. Tân Sơn Nhì, Tân Phú, TP. HCM",
        30000,
        "assets/images/achay/banner.jpg",
        0,
        listOf(
            "assets/images/achay/img1.jpg",
            "assets/images/achay/img2.jpg",
            "assets/images/achay/img3.jpg"
        )
    )
    val list = List(20) { index ->
        Food(
            "62b72b165e4e6e6e3c6a81e6",
            "A Chảy - Mì Sủi Cảo & Cơm Chiên Gà Xối Mỡ - Shop Online",
            "58/11 Nguyễn Văn Săng, P. Tân Sơn Nhì, Tân Phú, TP. HCM",
            30000 + index,
            "assets/images/achay/banner.jpg",
            0,
            listOf(
                "assets/images/achay/img1.jpg",
                "assets/images/achay/img2.jpg",
                "assets/images/achay/img3.jpg"
            )
        )
    }
    RecyclerView(modifier = Modifier.fillMaxHeight(), list = mutableStateOf(list), onclick = {})
}

@Composable
fun MySearchBar(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Icon(
            Icons.Rounded.Settings,
            contentDescription = null,
            tint = DarkColorScheme.primary,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(
                    color = Color.White, shape = RoundedCornerShape(10.dp)
                )
        )
        var search = ""
        val onValueChange: (String) -> Unit = {}
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            TextField(modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp),
                value = search,
                onValueChange = onValueChange,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                },
                trailingIcon = {
                    if (search.isEmpty()) {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.Adjust,
                                contentDescription = "Voice Search",
                                tint = DarkColorScheme.primary
                            )
                        }
                    } else {
                        IconButton(onClick = { search = "" }) {
                            Icon(
                                tint = DarkColorScheme.primary,
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                },
                placeholder = { Text("Search") })
        }
    }
}

@Preview
@Composable
fun Preview1() {
    MySearchBar(modifier = Modifier.fillMaxWidth())
}