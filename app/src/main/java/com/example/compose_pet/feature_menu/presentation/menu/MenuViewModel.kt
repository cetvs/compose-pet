package com.example.compose_pet.feature_menu.presentation.menu

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private var _state = mutableStateOf(listOf<MenuItem>())
    val state: State<List<MenuItem>> = _state

    fun getMenuItems() {
            menuUseCases.getMenuItems().onEach{
                _state.value = it
            }.launchIn(viewModelScope)
    }

    fun addMenuItem(menuItem: MenuItem) {
        viewModelScope.launch(Dispatchers.IO) {
            menuUseCases.addMenuItem(menuItem)
        }
    }

}