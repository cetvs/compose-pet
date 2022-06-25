package com.example.compose_pet.feature_menu.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.compose_pet.feature_menu.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDao {
    @Query("SELECT * FROM menuItem")
    fun getMenuItems(): Flow<List<MenuItem>>

    @Query("DELETE FROM menuItem")
    fun deleteAllMenuItems()

    @Delete
    fun deleteMenuItem(menuItem: MenuItem)

    @Insert
    fun insertMenuItem(menuItem: MenuItem)
}