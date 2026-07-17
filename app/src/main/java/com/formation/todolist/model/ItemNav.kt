package com.formation.todolist.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

///

sealed class ItemNav(
    val name: String,
    val icon: ImageVector,
    val color: Color,
    val route: String
) {
    object Home :
        ItemNav(name = "Home", icon = Icons.Default.Home, color = Color.Black, route = "home")

    object Portfolio : ItemNav(name = "Portfolio", icon = Icons.Default.Star, color = Color.Black, route = "portfolio")
    object Settings : ItemNav(
        name = "Settings",
        icon = Icons.Default.Settings,
        color = Color.Black,
        route = "settings"
    )

    object About :
        ItemNav(name = "About", icon = Icons.Default.Info, color = Color.Black, route = "about")

    object LinkedIn :
        ItemNav(name = "LinkedIn", icon = Icons.Default.Info, color = Color.Black, route = "linkedin")

    object Weather :
        ItemNav(name = "Weather", icon = Icons.Default.AcUnit, color = Color.Black, route = "weather")
}