package com.example.compose_pet.feature_menu.presentation.menu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_pet.R

@Composable
fun StockList(list: List<Int>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
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
        modifier = Modifier
            .background(Color.Blue)
            .size(230.dp, 100.dp)
    ) {
        Image(
            modifier = Modifier.size(300.dp, 112.dp),
            painter = painterResource(id = imageId),
            contentDescription = null
        )
    }
}

val lstOfStock = listOf(R.drawable.stock, R.drawable.stock)