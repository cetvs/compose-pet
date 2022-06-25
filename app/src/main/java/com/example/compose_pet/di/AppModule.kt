package com.example.compose_pet.di

import android.app.Application
import androidx.room.Room
import com.example.compose_pet.feature_menu.data.repository.MenuRepositoryImpl
import com.example.compose_pet.feature_menu.data.source.local.AppDatabase
import com.example.compose_pet.feature_menu.domain.repository.MenuRepository
import com.example.compose_pet.feature_menu.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFoodDatabase(app : Application): AppDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepositoryDatabase(db: AppDatabase) : MenuRepository{
        return MenuRepositoryImpl(db.menuDao())
    }

    @Provides
    @Singleton
    fun provideMenuUseCases(menuRepository: MenuRepository) : MenuUseCases{
        return MenuUseCases(
            getMenuItems = GetMenuItems(menuRepository),
            deleteMenuItems = DeleteMenuItem(menuRepository),
            addMenuItem = AddMenuItem(menuRepository),
            deleteAllMenuItems = DeleteAllMenuItems(menuRepository)
        )
    }
}