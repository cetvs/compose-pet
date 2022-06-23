package com.example.compose_pet.feature_menu.presentation.bottom_navigation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import com.example.compose_pet.R

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Int,
    val badgeCount: Int = 0
) {
    object Menu : BottomNavItem(
        route = "menu",
        name = "Меню",
        icon = R.drawable.ic_menu
    )

    object Profile : BottomNavItem(
        route = "profile",
        name = "Профиль",
        icon =  R.drawable.ic_profile
    )

    object ShoppingCart : BottomNavItem(
        route = "shoppingCart",
        name = "Корзина",
        icon = R.drawable.ic_shopping_cart
    )
}