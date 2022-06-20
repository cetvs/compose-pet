package com.example.compose_pet.feature_menu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menuItem")
data class MenuItem(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val foodType: String,
    val price: Int,
    val image: Int
)