package com.example.compose_pet.feature_menu.presentation.bottom_navigation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.presentation.menu.CategoryTab
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun MenuScreen() {
    LazyColumn() {
        stickyHeader {
            StockList(lstOfStock)
        }

    }
    CategoryTab()
}

@Composable
fun StockList(list: List<Int>) {
    LazyColumn(
        modifier = Modifier.wrapContentSize(unbounded = true)
    ) {
        items(
            count = list.size,
            itemContent = {
                StockListItem(list[it])
            }
        )
    }
}

@Composable
fun StockListItem(imageId: Int) {
    Row(
        horizontalArrangement = Arrangement.End
    ) {
        Image(painter = painterResource(id = imageId), contentDescription = null)
    }
}

val lstOfStock = listOf(R.drawable.stock, R.drawable.stock)
