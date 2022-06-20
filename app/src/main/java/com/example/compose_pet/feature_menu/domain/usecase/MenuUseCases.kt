package com.example.compose_pet.feature_menu.domain.usecase

class MenuUseCases(
    val getMenuItems: GetMenuItems,
    val deleteMenuItems: DeleteMenuItem,
    val addMenuItem: AddMenuItem,
) {
}