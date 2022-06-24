package com.example.compose_pet.feature_menu.presentation.menu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.domain.model.MenuItem
import com.example.compose_pet.feature_menu.presentation.menu.MenuViewModel

@Composable
fun MenuList(
    viewModel: MenuViewModel = hiltViewModel(),
) {
    val state = viewModel.getMenuItems().collectAsState(initial = listOf())
    val foods = state.value

    Surface(modifier = Modifier.fillMaxHeight()) {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(
                count = foods.size,
                itemContent = {
                    MenuListItem(foods[it])
                }
            )
        }
    }
}

@Composable
fun MenuListItem(menuItem: MenuItem) {
    Row() {
        MenuItemImage(R.drawable.pizza)
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(menuItem.name, style = MaterialTheme.typography.h6)
            Text(menuItem.description, style = MaterialTheme.typography.caption)
            val color = Color.Red
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .border(
                        width = 1.dp,
                        color = color,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(8.dp),
                text = "от ${menuItem.price} р",
                color = color,
            )
        }
    }
}

@Composable
private fun MenuItemImage(imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .padding(8.dp)
    )
}

val food = MenuItem(1, "pizza", "is pizze", "pizza", 400, R.drawable.pizza)
//val foods = listOf<MenuItem>(food, food.copy(name = "2 pizza"), food.copy(name = "3 pizza"))
