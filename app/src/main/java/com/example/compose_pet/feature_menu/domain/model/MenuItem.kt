package com.example.compose_pet.feature_menu.domain.model

data class MenuItem(
    val name: String,
    val description: String,
    val foodType: String,
    val price: Int,
    val image: Int
)
