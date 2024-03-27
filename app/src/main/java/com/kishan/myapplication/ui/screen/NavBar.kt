package com.kishan.myapplication.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

data class BottomNavItem(
    val label: String,
)

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "For You",
        ),
        BottomNavItem(
            label = "Top Search",
        ),
    )
}

@Composable
fun BottomNavigationBar() {
    val selected = remember {
        mutableStateOf("For You")
    }
    Scaffold(bottomBar = {
        BottomAppBar() {
            Text(text = "For You",
                style = TextStyle(color = if (selected.value == "For You") Color.White else Color.LightGray,)
                )
            Text(text = "Top Search",
                style = TextStyle(color = if (selected.value == "Top Search") Color.White else Color.LightGray,)
            )
        }
    }) {
        Modifier.padding(it)
    }
}