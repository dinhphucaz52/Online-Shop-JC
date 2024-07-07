package com.example.onlineshop.ui.navigation.detail.food

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.sharp.Casino
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.onlineshop.domain.model.Food
import com.example.onlineshop.ui.component.BannerSlider
import com.example.onlineshop.ui.component.FoodItem
import com.example.onlineshop.ui.theme.DarkColorScheme
import com.example.onlineshop.utils.FakeData
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailScreen(
    food: Food, viewModel: FoodViewModel,
    foodList: List<Food>
) {

    var foodState by remember {
        mutableStateOf(food)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = DarkColorScheme.background
            )
    ) {

        var listUrlState by remember {
            mutableStateOf(foodState.getAllImg())
        }


        val lazyRow = createRef()
        BannerSlider(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF3D3D3C),
                            Color(0xFF2B2A29),
                            Color(0xFF3D3D3C),
                            Color(0xFF2B2A29),
                            Color(0xFF3D3D3C),
                            Color(0xFF2B2A29),
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    ),
                    shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
                )
                .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp))
                .constrainAs(lazyRow) {
                    top.linkTo(parent.top)
                }, listUrl = listUrlState
        )

        val box = createRef()
        Box(modifier = Modifier
            .constrainAs(box) {
                top.linkTo(lazyRow.bottom)
                bottom.linkTo(lazyRow.bottom)
                end.linkTo(parent.end)
            }
            .padding(end = 30.dp)
            .background(
                color = Color.White, shape = RoundedCornerShape(15.dp)
            )
            .size(50.dp)
            .border(width = 3.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp)),
            contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color(0xFFef500f)
            )
        }

        val text = createRef()
        Text(text = foodState.name.ifBlank { "Undefined" },
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            color = DarkColorScheme.tertiary,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .constrainAs(text) {
                    top.linkTo(box.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        val row = createRef()
        Row(modifier = Modifier
            .constrainAs(row) {
                top.linkTo(text.bottom)
            }
            .padding(top = 20.dp)
            .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "$${foodState.price}",
                textAlign = TextAlign.Start,
                fontSize = 50.sp,
                color = DarkColorScheme.tertiary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
            Box(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(15.dp)
                    )
                    .size(50.dp)
                    .border(width = 3.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Sharp.Casino,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize(),
                    tint = Color(0xFFef500f)
                )
            }
            Text(
                text = foodState.quantity.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 15.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(15.dp)
                    )
                    .size(50.dp)
                    .border(width = 3.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize(),
                    tint = Color(0xFFef500f)
                )
            }
        }

        val text2 = createRef()
        Text(text = "About",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .fillMaxWidth()
                .constrainAs(text2) {
                    top.linkTo(row.bottom)
                })

        val text3 = createRef()
        Text(text = foodState.address.ifBlank { "Undefined" }, maxLines = 1,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .fillMaxWidth()
                .constrainAs(text3) {
                    top.linkTo(text2.bottom)
                })

        val text4 = createRef()
        Text(text = "Other Foods",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .fillMaxWidth()
                .constrainAs(text4) {
                    top.linkTo(text3.bottom)
                })

        val verticalDivider = createRef()
        HorizontalDivider(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .constrainAs(verticalDivider) {
                    top.linkTo(text4.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }, color = Color.Gray, thickness = 2.dp
        )
        val lazyColumn = createRef()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(lazyColumn) {
                    top.linkTo(text4.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            itemsIndexed(foodList) { indexed, food ->
                FoodItem(food = food, indexed) {
                    foodState = food
                    listUrlState = food.getAllImg()
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        Food(), viewModel = FoodViewModel(), FakeData.FOOD_LIST
    )
}
