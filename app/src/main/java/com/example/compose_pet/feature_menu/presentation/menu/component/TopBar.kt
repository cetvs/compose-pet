package com.example.compose_pet.feature_menu.presentation.menu.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_pet.R

@Composable
fun TopBar(expandedCityState: MutableState<Boolean>) {
    var expandedCity by expandedCityState
    Row() {
        Text(
            modifier = Modifier.padding(16.dp, 42.dp, 0.dp, 0.dp),
            text = MOSCOW,
            style = MaterialTheme.typography.h6
        )
        IconButton(
            modifier = Modifier.padding(6.dp, 32.dp, 0.dp, 0.dp),
            onClick = { expandedCity = true }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_choose_city),
                contentDescription = null
            )
        }
        DropdownMenu(expanded = expandedCity, onDismissRequest = { expandedCity = false }) {
            DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                Text(SAINT_PETERSBURG)
            }
            DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                Text(VORONEZH)
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_qr_code),
            contentDescription = null,
            modifier = Modifier.padding(220.dp, 42.dp, 0.dp, 0.dp)
        )
    }
}

private const val MOSCOW = "Moсква"
private const val VORONEZH = "Воронеж"
private const val SAINT_PETERSBURG = "Санкт-Петербург"