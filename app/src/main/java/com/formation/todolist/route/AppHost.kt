package com.formation.todolist.route

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.formation.todolist.model.ItemNav
import com.formation.todolist.ui.view.BodyTodo
import com.formation.todolist.ui.view.pages.LinkedInScreen
import com.formation.todolist.ui.view.pages.PortfolioScreen
import com.formation.todolist.ui.view.pages.ProfileScreen
import com.formation.todolist.ui.view.pages.SettingScreen
import com.formation.todolist.ui.view.pages.WeatherScreen

@Composable
fun AppHost(navHostController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navHostController,
        startDestination = ItemNav.Home.route,
        modifier = modifier,
    ) {

 //     AppDatas().items.forEach { item ->
//            composable(item.route) {
//                    Text(text = item.name)
//            }

        composable(ItemNav.Home.route) {
            BodyTodo(
                modifier = Modifier
                    //.padding(innerPadding)
                    .fillMaxSize(),
            )
        }
        composable(ItemNav.Portfolio.route) { PortfolioScreen(
            modifier = Modifier
                .fillMaxSize(),
        ) }
        composable(ItemNav.Settings.route) { SettingScreen(
            modifier = Modifier
                .fillMaxSize(),
        ) }
        composable(ItemNav.About.route) { ProfileScreen(
            modifier = Modifier
                .fillMaxSize(),
        ) }

        composable(ItemNav.LinkedIn.route) {
            LinkedInScreen(
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
        composable(ItemNav.Weather.route) {
            WeatherScreen(
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }

}