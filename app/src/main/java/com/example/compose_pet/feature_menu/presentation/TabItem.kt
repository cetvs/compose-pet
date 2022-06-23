package com.example.compose_pet.feature_menu.presentation

import androidx.compose.runtime.Composable
import com.example.compose_pet.feature_menu.presentation.bottom_navigation.component.MenuScreen
import com.example.compose_pet.feature_menu.presentation.menu.component.FoodMenuList

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object Pizza : TabItem(Category.PIZZA.title, { FoodMenuList() })
    object Combo : TabItem(Category.COMBO.title, { FoodMenuList() })
    object Dessert : TabItem(Category.DESSERT.title, { FoodMenuList() })
    object Beverages : TabItem(Category.BEVERAGES.title, { FoodMenuList() })
}

enum class Category(val title: String) {
    PIZZA("Пицца"), COMBO("Комбо"), DESSERT("Десерт"), BEVERAGES("Напитки"),
}