package com.example.onlineshop.ui.screen

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.onlineshop.data.model.Food
import com.example.onlineshop.ui.theme.DarkColorScheme
import com.example.onlineshop.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    food: Food?,
    viewModel: DetailViewModel
) {
    if (food == null)
        return
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Cyan
            )
    ) {

        val lazyRow = createRef()
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
            )
            .constrainAs(lazyRow) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
        }

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
        Text(text = food.name,
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            color = DarkColorScheme.tertiary,
            fontWeight = FontWeight.Bold,
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
                text = "$${food.price}",
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
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize(),
                    tint = Color(0xFFef500f)
                )
            }
            Text(
                text = "10",
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
        Text(text = food.address,
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

        val lazyRow2 = createRef()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(lazyRow2) {
                    top.linkTo(text4.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .background(
                    color = Color.Cyan
                )
        ) {
            item {
                Icon(
                    imageVector = Icons.Default.BrokenImage,
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        Food(
            "62b72b165e4e6e6e3c6a81e6",
            "A Chảy - Mì Sủi Cảo & Cơm Chiên Gà Xối Mỡ - Shop Online",
            "58/11 Nguyễn Văn Săng, P. Tân Sơn Nhì, Tân Phú, TP. HCM",
            30000,
            "assets/images/achay/banner.jpg",
            quantity = 0,
            listOf(
                "assets/images/achay/img1.jpg",
                "assets/images/achay/img2.jpg",
                "assets/images/achay/img3.jpg"
            )
        ),
        viewModel = DetailViewModel()
    )
}
