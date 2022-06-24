package com.example.compose_pet.feature_menu.presentation

import androidx.compose.runtime.Composable
import com.example.compose_pet.feature_menu.presentation.menu.component.MenuList

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object Pizza : TabItem(Category.PIZZA.title, { MenuList() })
    object Combo : TabItem(Category.COMBO.title, { MenuList() })
    object Dessert : TabItem(Category.DESSERT.title, { MenuList() })
    object Beverages : TabItem(Category.BEVERAGES.title, { MenuList() })
}

enum class Category(val title: String) {
    PIZZA("Пицца"), COMBO("Комбо"), DESSERT("Десерт"), BEVERAGES("Напитки"),
}