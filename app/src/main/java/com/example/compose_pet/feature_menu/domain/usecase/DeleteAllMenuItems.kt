package com.example.compose_pet.feature_menu.domain.usecase

import com.example.compose_pet.feature_menu.domain.repository.MenuRepository

class DeleteAllMenuItems(
    private val repository: MenuRepository
) {
    operator fun invoke() {
        repository.deleteAllMenuItems()
    }
}