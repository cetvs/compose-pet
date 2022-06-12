package com.example.compose_pet.feature_menu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.model.BottomNavItem
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.MenuScreen
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.ProfileScreen
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.ShoppingCartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                listOf(
                    BottomNavItem.Menu,
                    BottomNavItem.Profile,
                    BottomNavItem.ShoppingCart
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        BottomNavGraph(navController = navController)
//        FoodHomeList()
    }
}

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
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.name) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray,
            )
        }
    }
}
