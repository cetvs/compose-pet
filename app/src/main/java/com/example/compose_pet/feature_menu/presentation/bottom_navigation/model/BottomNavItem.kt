package com.example.compose_pet.feature_menu.presentation.bottom_navigation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
) {
    object Menu : BottomNavItem(
        route = "menu",
        name = "Menu",
        icon = Icons.Default.Home
    )

    object Profile : BottomNavItem(
        route = "profile",
        name = "Profile",
        icon = Icons.Default.Person
    )

    object ShoppingCart : BottomNavItem(
        route = "shoppingCart",
        name = "ShoppingCart",
        icon = Icons.Default.ShoppingCart
    )
}