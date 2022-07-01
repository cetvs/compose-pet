package com.example.compose_pet.feature_menu.presentation.bottom_navigation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.presentation.menu.component.MenuWithCategoryTab
import com.example.compose_pet.feature_menu.presentation.menu.component.StockList
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
    var expandedCity by remember { mutableStateOf(false) }

    Column() {
        Row(modifier = Modifier.padding()) {
            Text(
                modifier = Modifier.padding(16.dp, 42.dp, 0.dp, 0.dp),
                text = "Moсква",
                style = MaterialTheme.typography.h6
            )
            IconButton(
                modifier = Modifier.padding(6.dp, 32.dp, 0.dp, 0.dp),
                onClick = { expandedCity = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_choose_city),
                    contentDescription = null
                )
            }
            DropdownMenu(expanded = expandedCity, onDismissRequest = { expandedCity = false }) {
                DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                    Text("Refresh")
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_qr_code),
                contentDescription = null,
                modifier = Modifier.padding(220.dp, 42.dp, 0.dp, 0.dp)
            )
        }
        AnimatedVisibility(visible) {
            StockList(lstOfStock)
        }
        MenuWithCategoryTab(menuListState)
    }
}

val lstOfStock = listOf(R.drawable.stock, R.drawable.stock)