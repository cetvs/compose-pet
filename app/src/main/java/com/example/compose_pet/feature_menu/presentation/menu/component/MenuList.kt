package com.example.compose_pet.feature_menu.presentation.menu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
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
    menuListState: LazyListState,
    viewModel: MenuViewModel = hiltViewModel(),
) {
//    viewModel.deleteAllMenuItems()
//    viewModel.addMenuItem(food1)
//    viewModel.addMenuItem(food2)
//    viewModel.addMenuItem(food3)
//    viewModel.addMenuItem(food2.copy(id = 4))
//    viewModel.addMenuItem(food2.copy(id = 5))
//    viewModel.addMenuItem(food2.copy(id = 6))
//    viewModel.addMenuItem(food2.copy(id = 7))
//    viewModel.addMenuItem(food2.copy(id = 8))
    val state = viewModel.getMenuItems().collectAsState(initial = listOf())
    val foods = state.value

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxHeight(), state = menuListState) {
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
    Row(Modifier.fillMaxHeight()) {
        MenuItemImage(R.drawable.pizza)
        Column(
            modifier = Modifier
                .padding(8.dp, 16.dp)
                .fillMaxWidth()
        ) {
            Text(menuItem.name, style = MaterialTheme.typography.h6)
            Text(menuItem.description, style = MaterialTheme.typography.caption, )
            val color = Color.Red
            PriceText(menuItem, color)
        }
    }
}

@Composable
private fun PriceText(menuItem: MenuItem, color: Color) {
    Row(modifier = Modifier.padding(105.dp, 45.dp, 0.dp, 0.dp)) {
        Text(
            text = "от ${menuItem.price} р",
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = color,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(18.dp, 8.dp),
            color = color,
        )
    }
}


@Composable
private fun MenuItemImage(imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .padding(16.dp)
            .size(135.dp)
    )
}

val food1 = MenuItem(
    1,
    "Ветчина и грибы",
    "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
    "pizza",
    345,
    R.drawable.pizza
)
val food2 = MenuItem(
    2,
    "Баварские колбаски",
    "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
    "pizza",
    345,
    R.drawable.pizza
)
val food3 = MenuItem(
    3,
    "Нежный лосось",
    "Лосось, томаты, оливки,соус песто,помидорки черри",
    "pizza",
    345,
    R.drawable.pizza
)
//val foods = listOf<MenuItem>(food, food.copy(name = "2 pizza"), food.copy(name = "3 pizza"))
