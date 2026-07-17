package com.formation.todolist.ui.view
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.formation.todolist.model.ItemNav
import com.formation.todolist.route.AppDatas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navController: NavController,currentRoute: String?) {

  //  val backStackEntry = navController.currentBackStackEntryAsState()

    // navigate to the current destination
   // val currentRoute = backStackEntry.value?.destination?.route

    Log.d("AppBar", "currentRoute: $currentRoute")

    val currentItem = AppDatas().items.find { it.route == currentRoute }

    if (currentRoute == ItemNav.LinkedIn.route || currentRoute == ItemNav.Weather.route) {
        TopAppBar(
            title = { Text(text = currentItem?.name?: "") },
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Home")
                }
            }
        )
    } else {

    CenterAlignedTopAppBar(
        title = { Text(text = currentItem?.name?: "") },
     //   expandedHeight = 0.dp,
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = { navController.navigate(ItemNav.LinkedIn.route) }) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "profile")
            }
        },
      actions = {
          IconButton(onClick = { navController.navigate(ItemNav.Weather.route) }) {
              Icon(Icons.Filled.AcUnit, contentDescription = "weather")
          }
      }
    )
}}