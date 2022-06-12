package com.example.compose_pet.feature_menu.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_pet.R
import com.example.compose_pet.feature_menu.domain.model.MenuItem

//@Preview
@Composable
fun FoodHomeList() {
    Surface {
        LazyColumn(
//            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items(
                count = foods.size,
                itemContent = {
                    FoodListItem(foods[it])
                    Divider(color = Color.LightGray, thickness = 1.dp)
                }
            )
        }
    }
}

@Composable
fun FoodListItem(menuItem: MenuItem) {
    Row() {
        PizzaImage(menuItem.image)
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
//            PizzaPrice(price = foodItem.price)
        }
    }
}

@Composable
private fun PizzaImage(imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .padding(8.dp)

    )
}

@Composable
private fun PizzaPrice(price: Int) {
    val color = Color.Magenta
    Text(
        modifier = Modifier
            .border(BorderStroke(1.dp, color = color))
            .padding(8.dp),
        text = "от $price р",
        color = color
    )
}

val food = MenuItem("pizza", "is pizze", "pizza", 400, R.drawable.pizza)
val foods = listOf(food, food.copy(name = "2 pizza"), food.copy(name = "3 pizza"))
