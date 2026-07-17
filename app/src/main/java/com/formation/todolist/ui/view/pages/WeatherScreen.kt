package com.formation.todolist.ui.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.formation.todolist.ui.theme.TodoListTheme
import com.formation.todolist.ui.view.WeatherComponent
import com.formation.todolist.ui.view.WeatherItem

@Composable
fun WeatherScreen(modifier: Modifier = Modifier) {

    var textFieldValue = TextFieldState()

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = "Weather")
        // meteo recap
        WeatherComponent()

        // search
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                state = textFieldValue,
                label = {},
                colors = TextFieldColors(

                ),
                placeholder = {Text(text = "Search")},
                trailingIcon = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }


            )


        // weather listle
        LazyColumn(

        )

        {
            items(count = 10) { tem ->
                WeatherItem()
                HorizontalDivider()
            }
        }


        // WeatherItem()
    }
}

@Preview
@Composable
private fun WeatherScreenPreview() {

    TodoListTheme {
        WeatherScreen()
    }

}
