package com.example.compose_pet.feature_menu.presentation.menu.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TestAnimation() {

    Column() {
//        Button(onClick = { visible = !visible }) {
//
//        }

        val state = rememberLazyListState()
        val visible by remember { derivedStateOf { state.firstVisibleItemIndex == 0 } }

        AnimatedVisibility(visible) {
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .size(100.dp, 100.dp)
            ) {

            }
        }

        LazyColumn(
//            modifier = Modifier.fillMaxWidth(),
            state = state
        ) {
            items(
                count = 10,
                itemContent = { ListItem() }
            )
        }

//        if (state.firstVisibleItemIndex > 0) {
//            { visible = !visible }
//        }
    }


}

@Composable
fun ListItem() {
    Row(
        modifier = Modifier
            .background(Color.Blue)
            .height(100.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(7.dp)
            )
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(Color.Green)
        )
    }
}