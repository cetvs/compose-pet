package com.example.compose_pet.feature_menu.domain.usecase

import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.domain.repository.MenuRepository

class AddMenuItem(
    private val repository: MenuRepository
) {
    operator fun invoke(menuItem: MenuItem) {
        repository.addMenuItem(menuItem)
    }
}