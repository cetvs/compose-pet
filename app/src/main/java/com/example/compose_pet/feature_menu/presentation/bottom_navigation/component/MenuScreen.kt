package com.example.compose_pet.feature_menu.presentation.bottom_navigation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.presentation.menu.component.MenuWithCategoryTab
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun MenuScreen() {
    LazyColumn(Modifier.fillMaxSize()) {
        stickyHeader {
            StockList(lstOfStock)
        }
        items(count = 1){
            MenuWithCategoryTab()
        }
    }
}

@Composable
fun StockList(list: List<Int>) {
    Box(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            LazyRow(
                state = rememberLazyListState(),
            ) {
                items(
                    count = list.size,
                    itemContent = {
                        StockListItem(list[it])
                    }

                )
            }

        }
    }
}

@Composable
fun StockListItem(imageId: Int) {
    Row(
        modifier = Modifier.background(Color.Blue).size(230.dp, 100.dp)
//        horizontalArrangement = Arrangement.End
    ) {
        Image(modifier = Modifier.size(280.dp, 200.dp) ,painter = painterResource(id = imageId), contentDescription = null)
    }
}

val lstOfStock = listOf(R.drawable.stock, R.drawable.stock)

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Preview
@Composable
fun StockListItem() {
    MenuScreen()
}