package com.formation.todolist.ui.view

import android.util.Log
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
import coil3.compose.AsyncImage
import com.formation.todolist.R
import com.formation.todolist.model.Forecast
import com.formation.todolist.model.WeatherResponse
import com.formation.todolist.services.ImageHelper
import com.formation.todolist.ui.theme.TodoListTheme

@Composable
fun WeatherComponent(modifier: Modifier = Modifier, result: WeatherResponse) {

    val main = result.list.first().main
    val weather = result.list.first().weather.first()

    val city = "${result.city.name} (${result.city.country})"

    Card (modifier = modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // lieu

            Text(text = city, fontWeight = FontWeight.Bold, fontSize = 20.sp)

            // row (imege, temperature)
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                ) {
                // image
                Image(
                    painter = painterResource(id = ImageHelper().iconWeather(weather.icon)),
                    contentDescription = weather.description,
                    contentScale = ContentScale.Crop,
                    modifier = modifier.size(100.dp)
                )

//                AsyncImage(
//                    model = "https://openweathermap.org/payload/api/media/file/${weather.icon}@2x.png",
//                    contentDescription = main.temp.toString(),
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier.size(100.dp),
//                    placeholder = painterResource(id = R.drawable.rain_day),
//                    error = painterResource(id = R.drawable.rain_day),
//                    onLoading = {
//                        Log.d("WeatherItem", "Loading")
//                    },
//                    onError = {
//                        Log.d("WeatherItem", "Error : ${it.result}")
//                    }
//                    // loading = painterResource(id = R.drawable.rain_day),
//                )


                // temperature
               Text(text = "${main.temp}°C",fontWeight = FontWeight.Bold, fontSize = 35.sp)
            }
            // description

            Text(
                text = weather.description,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}