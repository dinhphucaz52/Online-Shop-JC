package com.example.onlineshop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.More
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
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.example.onlineshop.R
import com.example.onlineshop.domain.model.Food
import com.example.onlineshop.ui.navigation.screen.home.HomeViewModel
import com.example.onlineshop.ui.theme.DarkColorScheme
import com.example.onlineshop.utils.FakeData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


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

@Composable
fun FoodItem(
    food: Food, indexed: Int, onclick: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .background(DarkColorScheme.background)
            .fillMaxWidth()
            .border(
                width = 2.dp, color = Color(0xFFff942b), shape = RoundedCornerShape(20.dp)
            )
            .height(150.dp)
            .padding(10.dp)
            .clickable { onclick() }
    ) {
        val image = createRef()
        Image(painter = painterResource(id = R.drawable.food),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(10.dp))
                .aspectRatio(1f)
                .constrainAs(image) {
                    end.linkTo(parent.end)
                })

        val icon = createRef()
        Image(painter = painterResource(id = R.drawable.ic),
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

        val rating = 4
        val ratingBar = createRef()

        Row(
            modifier = Modifier.constrainAs(ratingBar) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            }, verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 1..5) {
                val starIcon = if (i <= rating) {
                    Icons.Filled.Star
                } else {
                    Icons.Outlined.StarOutline
                }
                Icon(imageVector = starIcon,
                    contentDescription = null,
                    tint = Color(0xFF1bc100),
                    modifier = Modifier
                        .clickable {
                            //TODO: handle click
                        }
                        .size(24.dp))
            }
            Text(text = "12 Ratings", modifier = Modifier.padding(start = 5.dp))
        }

        Column(
            modifier = Modifier.constrainAs(createRef()) {
                start.linkTo(parent.start)
                top.linkTo(icon.bottom)
                end.linkTo(image.start)
                bottom.linkTo(ratingBar.top)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }, verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = food.name,
                modifier = Modifier,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${food.price} VND",
                modifier = Modifier,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }


    }
}

@Composable
fun RecyclerView(
    viewModel: HomeViewModel?, modifier: Modifier, onclick: (Int) -> Unit
) {
    val listFood = viewModel?.foodListState?.value
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp)),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        itemsIndexed(listFood ?: emptyList()) { indexed, food ->
            FoodItem(food = food, indexed) {
                onclick(indexed)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar(
    modifier: Modifier
) {
    var text by remember { mutableStateOf("") } // Query for SearchBar
    var active by remember { mutableStateOf(false) } // Active state for SearchBar

    SearchBar(
        trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        placeholder = { Text(text = "Search food here...") },
        modifier = modifier,
        query = text,
        onQueryChange = { text = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = { active = it },
    ) {
        FakeData.SEARCH_HISTORY.forEach {
            if (it.isNotEmpty()) {
                Row(modifier = Modifier.padding(all = 14.dp)) {
                    Icon(imageVector = Icons.Default.History, contentDescription = null)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = it)
                }
            }
        }
        Divider()
        Text(
            modifier = Modifier
                .padding(all = 14.dp)
                .fillMaxWidth()
                .clickable {
                    FakeData.SEARCH_HISTORY.clear()
                },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            text = "clear all history"
        )

    }
}

@Preview
@Composable
fun SearchBarPreview(
) {
    MySearchBar(
        modifier = Modifier
            .fillMaxWidth()
    )
}


@ExperimentalPagerApi
@Composable
fun BannerSlider(
    modifier: Modifier,
    listUrl: List<String>,
    itemSpacing: Int = 0,
    contentPaddingValues: Int = 0
) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = listUrl.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = contentPaddingValues.dp),
        modifier = modifier,
        itemSpacing = itemSpacing.dp
    ) { page ->
        BannerItem(listUrl[page], modifier)
    }
}

@Composable
fun BannerItem(url: String, modifier: Modifier) {
    Image(
        painter = rememberAsyncImagePainter(model = url),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}