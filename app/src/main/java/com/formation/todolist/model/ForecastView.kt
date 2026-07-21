package com.formation.todolist.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.formation.todolist.ui.view.WeatherItem

@Composable
fun ForecastView(modifier: Modifier = Modifier, result: WeatherResponse) {

  //  Column {
       // Text(text = result.cnt.toString())

        LazyColumn(
            modifier = modifier.fillMaxSize()

        )

        {
            items(result.list) { forecast ->
                WeatherItem(item = forecast)
                HorizontalDivider()
            }
        }
  //  }

}