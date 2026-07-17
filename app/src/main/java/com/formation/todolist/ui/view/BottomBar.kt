package com.formation.todolist.ui.view

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.formation.todolist.model.ItemNav
import com.formation.todolist.route.AppDatas

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar() {
        // backstack entry
        val backStackEntry = navController.currentBackStackEntryAsState()

        // navigate to the current destination
        val currentRoute = backStackEntry.value?.destination?.route

        if (currentRoute != ItemNav.LinkedIn.route) {

        AppDatas().items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
    }
}