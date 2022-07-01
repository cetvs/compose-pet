package com.example.compose_pet.feature_menu.domain.usecase

import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow

class GetMenuItems(
    private val repository: MenuRepository
) {
    operator fun invoke(): Flow<List<MenuItem>> {
        return repository.getMenuItems()
//        return MutableStateFlow(listOf(food))
    }
}

val food = MenuItem(1, "pizza", "is pizze", "pizza", 400, R.drawable.pizza)