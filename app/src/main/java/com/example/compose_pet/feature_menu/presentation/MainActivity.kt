package com.example.compose_pet.feature_menu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.model.BottomNavItem
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.BottomNavGraph
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.BottomNavigationBar
import com.example.compose_pet.feature_menu.presentation.menu.component.TestAnimation
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
//            TestAnimation()
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
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
        BottomNavGraph(navController)
    }
}
