package com.example.compose_pet.feature_menu.domain.usecase

import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.domain.repository.MenuRepository

class DeleteMenuItem (
    private val repository: MenuRepository
){

    operator fun invoke(menuItems: MenuItem){
        repository.deleteMenuItems(menuItems)
    }
}