package com.example.compose_pet.feature_menu.presentation.bottom_navigation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.presentation.menu.component.MenuWithCategoryTab
import com.example.compose_pet.feature_menu.presentation.menu.component.StockList
import com.example.compose_pet.feature_menu.presentation.menu.component.TopBar
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun MenuScreen() {
    val menuListState = rememberLazyListState()
    val visible by remember {
        derivedStateOf {
            menuListState.firstVisibleItemIndex == 0 || menuListState.firstVisibleItemIndex == 1
        }
    }
    val expandedCity = remember { mutableStateOf(false) }
    Column {
        TopBar(expandedCity)
        AnimatedVisibility(visible) {
            StockList(lstOfStock)
        }
        MenuWithCategoryTab(menuListState)
    }
}

val lstOfStock = listOf(R.drawable.stock, R.drawable.stock)