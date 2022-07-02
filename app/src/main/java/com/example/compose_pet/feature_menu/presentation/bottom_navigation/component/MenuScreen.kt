package com.example.compose_pet.feature_menu.presentation.bottom_navigation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.presentation.menu.component.MenuWithCategoryTab
import com.example.compose_pet.feature_menu.presentation.menu.component.StockList
import com.example.compose_pet.feature_menu.presentation.menu.component.TopBar
import com.example.compose_pet.ui.theme.LightGray
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun MenuScreen() {
    val visibleState = remember { mutableStateOf(false) }
    val expandedCity = remember { mutableStateOf(false) }
    Column(modifier = Modifier.background(color = LightGray)) {
        TopBar(expandedCity)
        AnimatedVisibility(visibleState.value) {
            StockList(lstOfStock)
        }
        MenuWithCategoryTab(visibleState)
    }
}

val lstOfStock = listOf(R.drawable.stock, R.drawable.stock)