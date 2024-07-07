package com.example.onlineshop.ui.navigation.screen.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.onlineshop.R
import com.example.onlineshop.domain.model.Food
import com.example.onlineshop.ui.component.BannerSlider
import com.example.onlineshop.ui.component.FoodItem
import com.example.onlineshop.ui.component.MySearchBar
import com.example.onlineshop.ui.theme.DarkColorScheme
import com.example.onlineshop.utils.FakeData
import com.google.accompanist.pager.ExperimentalPagerApi

private const val TAG = "System.out"

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navigateToDetail: ((Food?, List<Food>?) -> Unit)?) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkColorScheme.background)
    ) {

        val background = createRef()
        Box(modifier = Modifier
            .constrainAs(background) {}
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFFffaf60), Color(0xFFff8914)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                ), shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            )
            .fillMaxWidth()
            .height(300.dp))

        val locationIcon = createRef()
        Icon(Icons.Default.LocationOn,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
                .constrainAs(locationIcon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

        val locationText = createRef()
        Text(text = "Ho Chi Minh",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(locationText) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(locationIcon.end, margin = 5.dp)
                bottom.linkTo(locationIcon.bottom)
            })

        val nameText = createRef()
        Text(text = "Hello, Nguyen Dinh Phuc",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(nameText) {
                top.linkTo(locationIcon.bottom, margin = 5.dp)
                start.linkTo(locationIcon.start, margin = 20.dp)
            })

        val userIcon = createRef()
        Image(painter = painterResource(id = R.drawable.img_user),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp, end = 20.dp)
                .constrainAs(userIcon) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(nameText.bottom)
                })

        val plusButton = createRef()
        Icon(imageVector = Icons.Default.ShoppingCart,
            contentDescription = null,
            tint = Color(0xFF754719),
            modifier = Modifier
                .constrainAs(plusButton) {
                    top.linkTo(userIcon.top, margin = 20.dp)
                    bottom.linkTo(userIcon.bottom)
                    end.linkTo(userIcon.start, margin = 5.dp)
                    height = Dimension.fillToConstraints
                }
                .aspectRatio(1f)
        )

        val searchBar = createRef()

        MySearchBar(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .constrainAs(searchBar) {
                    top.linkTo(nameText.bottom, margin = 5.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        val saleFoodImage = createRef()
        Image(painter = painterResource(id = R.drawable.food),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(
                    CircleShape
                )
                .constrainAs(saleFoodImage) {
                    end.linkTo(parent.end, margin = 20.dp)
                    top.linkTo(searchBar.bottom)
                    bottom.linkTo(background.bottom)
                })


        val saleButton = createRef()
        Box(modifier = Modifier
            .height(30.dp)
            .background(
                color = Color(0xFFd53300), shape = RoundedCornerShape(20.dp)
            )
            .constrainAs(saleButton) {
                bottom.linkTo(saleFoodImage.bottom)
                start.linkTo(parent.start, margin = 20.dp)
            }
            .padding(horizontal = 20.dp), contentAlignment = Alignment.Center) {
            Text(
                text = "MIN $150 OFF >>",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        val text = createRef()
        Text(text = """
                Explosive Offers
                for you!
            """.trimIndent(),
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier.constrainAs(
                text
            ) {
                start.linkTo(parent.start, margin = 20.dp)
                bottom.linkTo(saleButton.top, margin = 5.dp)
            })

        val bannerSlider = createRef()

        val bannerList = homeViewModel.foodListState.collectAsState().value?.map {
            it.img
        }

        BannerSlider(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .height(150.dp)
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
                    )
                )
                .constrainAs(bannerSlider) {
                    top.linkTo(background.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentPaddingValues = 10,
            itemSpacing = 10,
            listUrl = bannerList ?: emptyList()
        )

        val text2 = createRef()
        Text(text = "FOR YOU",
            fontSize = 16.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier
                .constrainAs(
                    text2
                ) {
                    top.linkTo(bannerSlider.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Canvas(
            Modifier
                .constrainAs(createRef()) {
                    top.linkTo(text2.top)
                    bottom.linkTo(text2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(text2.start)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = 20.dp),
        ) {
            drawLine(
                color = Color.Gray,
                strokeWidth = 2.dp.toPx(),
                start = Offset(0f, 2.dp.toPx() / 2),
                end = Offset(size.width, 2.dp.toPx() / 2),
            )
        }

        Canvas(
            Modifier
                .fillMaxWidth()
                .height(2.dp)
                .constrainAs(createRef()) {
                    top.linkTo(text2.top)
                    bottom.linkTo(text2.bottom)
                    start.linkTo(text2.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = 20.dp),
        ) {
            drawLine(
                color = Color.Gray,
                strokeWidth = 2.dp.toPx(),
                start = Offset(0f, 2.dp.toPx() / 2),
                end = Offset(size.width, 2.dp.toPx() / 2),
            )
        }


        var selectedTabIndex by remember { mutableIntStateOf(0) }
        val tabTitles = listOf("Recommended", "Favourites")

        val tabRow = createRef()

        TabRow(selectedTabIndex = selectedTabIndex, indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .height(2.dp)
                    .background(color = Color(0xFFFFA726))
            )
        }, modifier = Modifier
            .constrainAs(tabRow) {
                top.linkTo(text2.bottom)
            }
            .padding(8.dp)
            .background(
                Color.LightGray.copy(alpha = 0.2f), shape = RoundedCornerShape(16.dp)
            )) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            if (title == "Favourites") {
                                Icon(
                                    Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = if (selectedTabIndex == index) Color(0xFFFFA726) else Color.Black
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                            Text(
                                text = title,
                                color = if (selectedTabIndex == index) Color(0xFFFFA726) else Color.Black,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp
                            )
                        }
                    },
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .background(
                            color = if (selectedTabIndex == index) Color(0xFFFFF3E0) else Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                )
            }
        }

        val lazyColumn = createRef()
        val foodList = homeViewModel.foodListState.collectAsState()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .constrainAs(lazyColumn) {
                    top.linkTo(tabRow.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            val list: List<Food> = foodList.value?.toList() ?: FakeData.FOOD_LIST

            println(list)

            itemsIndexed(list) { indexed, food ->
                FoodItem(food = food, indexed) {
                    navigateToDetail
                        ?.invoke(food, list)
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(HomeViewModel(), null)
}