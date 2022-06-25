package com.example.compose_pet.feature_menu.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.domain.usecase.MenuUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuUseCases: MenuUseCases
) : ViewModel() {
//    var flow: Flow<List<MenuItem>> = flow<List<MenuItem>>(){}

    fun getMenuItems() : Flow<List<MenuItem>>{
        return menuUseCases.getMenuItems()
    }

    fun deleteAllMenuItems(){
        viewModelScope.launch(Dispatchers.IO) {
            menuUseCases.deleteAllMenuItems()
        }
    }

    fun addMenuItem(menuItem: MenuItem) {
        viewModelScope.launch(Dispatchers.IO) {
            menuUseCases.addMenuItem(menuItem)
        }
    }

}