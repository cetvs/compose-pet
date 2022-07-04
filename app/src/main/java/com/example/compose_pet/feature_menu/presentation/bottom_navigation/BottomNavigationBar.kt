package com.example.compose_pet.feature_menu.presentation.bottom_navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.MenuScreen
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.ProfileScreen
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.ShoppingCartScreen
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.model.BottomNavItem
import com.example.compose_pet.feature_menu.presentation.ui.theme.CustomGray
import com.example.compose_pet.feature_menu.presentation.ui.theme.CustomPurple
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Menu.route
    ) {
        composable(route = BottomNavItem.Menu.route) {
            MenuScreen()
        }
        composable(route = BottomNavItem.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomNavItem.ShoppingCart.route) {
            ShoppingCartScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        elevation = 5.dp,
        backgroundColor = CustomGray
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.name) },
                label = { Text(text = item.name) },
                selectedContentColor = CustomPurple,
                unselectedContentColor = Color.Gray,
            )
        }
    }
}

