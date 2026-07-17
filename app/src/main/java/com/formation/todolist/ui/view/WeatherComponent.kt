package com.formation.todolist.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.formation.todolist.R
import com.formation.todolist.ui.theme.TodoListTheme

@Composable
fun WeatherComponent(modifier: Modifier = Modifier) {
    Card (modifier = modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // lieu

            Text(text = "NEW YORK", fontWeight = FontWeight.Bold, fontSize = 20.sp)

            // row (imege, temperature)
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                // image
                Image(
                    painter = painterResource(id = R.drawable.rain_day),
                    contentDescription = "Weather",
                    contentScale = ContentScale.Crop,
                    modifier = modifier.size(100.dp)
                )
                // temperature
               Text(text = "Peu nuageux",fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
            // description

            Text(
                text = "Peu nuageux",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
private fun WeatherComponentPreview() {

    TodoListTheme {
        WeatherComponent()
    }

}