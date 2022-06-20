package com.example.compose_pet.feature_menu.presentation.bottom_navigation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose_pet.feature_menu.presentation.menu.component.FoodMenuList
import com.example.compose_pet.ui.theme.CustomPurple

@Composable
fun MenuScreen() {
    MyTab()
    FoodMenuList()
}

@Composable
fun MyTab() {

    val tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf("tab1", "tab2", "tab3")
    TabRow(
        selectedTabIndex = tabIndex,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        tabData.forEachIndexed { index, data ->
            val selected = index == tabIndex
            Tab(
                selected = selected,
                onClick = { },
                modifier = Modifier,
                enabled = true,
                text = {
                    Text(
                        text = data
                    )
                },
                icon = null,
                interactionSource = MutableInteractionSource(),
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = CustomPurple
            )
        }
//        Tab(
//            selected = true,
//            onClick = { },
//            modifier = Modifier,
//            enabled = true,
//            text = Text(),
//            icon = null,
//            interactionSource = MutableInteractionSource(),
//            selectedContentColor = LocalContentColor.current,
//            unselectedContentColor = CustomPurple
//        )
    }
}