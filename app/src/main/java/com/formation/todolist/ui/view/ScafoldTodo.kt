package com.formation.todolist.ui.view

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.formation.todolist.model.ItemNav
import com.formation.todolist.route.AppHost

@Composable
fun ScaffoldTodo() {
    val navController = rememberNavController()

    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route

    Log.d("SCAFFOLD : ", "${navController.currentDestination?.route}")

    Scaffold(
        topBar = {
            AppBar(
                navController = navController,
                currentRoute = currentRoute,
            )
        },
        floatingActionButton = {
            if (currentRoute == ItemNav.Home.route) {
                FloatingActionButton(
                    shape = CircleShape,
                    onClick = {
                        /* TODO
                        /// ouvre la page de creation de todo
                        // en mode sheet

                     */
                    }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Start,
        bottomBar = {
            if (currentRoute != ItemNav.LinkedIn.route && currentRoute != ItemNav.Weather.route) {
                BottomBar(navController = navController)
            }
        },
        content = { innerPadding ->
            AppHost(
                navHostController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}