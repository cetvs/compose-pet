package com.example.compose_pet.feature_menu.presentation.menu.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose_pet.feature_menu.presentation.Category
import com.example.compose_pet.feature_menu.presentation.TabItem
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.MenuScreen
import com.example.compose_pet.ui.theme.CustomPurple
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun MenuWithCategoryTab(menuListState: LazyListState) {
    val tabs = listOf(
        TabItem(PIZZA) { MenuList(menuListState) },
        TabItem(COMBO) { MenuList(menuListState) },
        TabItem(DESSERT) { MenuList(menuListState) },
        TabItem(BEVERAGES) { MenuList(menuListState) }
    )
    val pagerState = rememberPagerState(initialPage = 0)

    Column(modifier = Modifier.fillMaxSize()) {
        Tabs(tabs = tabs, pagerState = pagerState)
        TabsContent(tabs = tabs, pagerState = pagerState)
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = Color.White
    ) {
        tabs.forEachIndexed { index, data ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                modifier = Modifier
                    .size(120.dp, 60.dp)
                    .padding(5.dp, 12.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(7.dp)
                    ),
//                    .shadow(1.dp, shape = RoundedCornerShape(14.dp), true),
                selectedContentColor = CustomPurple,
                unselectedContentColor = Color.Gray,

                text = { Text(text = tabs[index].title) },
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(
        count = tabs.size,
        modifier = Modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        tabs[page].screen()
    }
}

const val PIZZA = "Пицца"
const val COMBO = "Комбо"
const val DESSERT = "Десерт"
const val BEVERAGES = "Напитки"
