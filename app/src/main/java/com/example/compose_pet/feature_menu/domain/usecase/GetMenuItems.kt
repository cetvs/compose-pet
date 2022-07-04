package com.example.compose_pet.feature_menu.domain.usecase

import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow

class GetMenuItems(
    private val repository: MenuRepository
) {
    operator fun invoke(): Flow<List<MenuItem>> {
        return repository.getMenuItems()
    }
}