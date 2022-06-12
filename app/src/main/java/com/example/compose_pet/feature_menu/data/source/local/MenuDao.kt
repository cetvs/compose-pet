package com.example.compose_pet.feature_menu.data.source.local

import androidx.room.Dao
import androidx.room.Query
import com.example.compose_pet.feature_menu.domain.model.MenuItem

@Dao
interface MenuDao {
    @Query("SELECT * FROM  ")
    fun getSortByAlphabet(): List<MenuItem>

}