package com.example.compose_pet.feature_menu.data.repository

import com.example.compose_pet.feature_menu.data.source.local.MenuDao
import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow

class MenuRepositoryImpl(
    private val menuDao: MenuDao
) : MenuRepository {
    override fun getMenuItems(): Flow<List<MenuItem>> {
        return menuDao.getMenuItems()
    }

    override fun deleteMenuItems(menuItem: MenuItem) {
        menuDao.deleteMenuItem(menuItem)
    }

    override fun addMenuItem(menuItem: MenuItem) {
        menuDao.insertMenuItem(menuItem)
    }
}