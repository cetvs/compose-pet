package com.example.compose_pet.feature_menu.data.repository

import android.util.Log
import com.example.compose_pet.feature_menu.data.source.local.MenuDao
import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.domain.repository.MenuRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch

class MenuRepositoryImpl(
    private val menuDao: MenuDao
) : MenuRepository {
    override fun getMenuItems(): Flow<List<MenuItem>> {
        return menuDao.getMenuItems()
    }

    override fun deleteAllMenuItems() {
        menuDao.deleteAllMenuItems()
    }

    override fun deleteMenuItems(menuItem: MenuItem) {
        menuDao.deleteMenuItem(menuItem)
    }

    override fun addMenuItem(menuItem: MenuItem) {
        menuDao.insertMenuItem(menuItem)
    }
}