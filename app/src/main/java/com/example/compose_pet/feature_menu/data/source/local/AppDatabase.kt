package com.example.compose_pet.feature_menu.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.compose_pet.feature_menu.domain.model.MenuItem

@Database(entities = [MenuItem::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun menuDao(): MenuDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "person_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}