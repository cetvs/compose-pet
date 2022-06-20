package com.example.compose_pet.feature_menu.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.compose_pet.feature_menu.domain.model.MenuItem

@Database(entities = [MenuItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao

    companion object {
        const val DATABASE_NAME = "food_database"
    }
}