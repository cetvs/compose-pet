package com.example.compose_pet.feature_menu.domain.repository

import com.example.compose_pet.feature_menu.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    fun getMenuItem(): Flow<List<MenuItem>>
}