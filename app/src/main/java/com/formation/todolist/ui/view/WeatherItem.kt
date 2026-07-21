package com.formation.todolist.ui.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.formation.todolist.R
import com.formation.todolist.model.Forecast
import com.formation.todolist.model.ForecastView
import com.formation.todolist.services.ImageHelper
import com.formation.todolist.ui.theme.TodoListTheme

@Composable
fun WeatherItem(modifier: Modifier = Modifier, item: Forecast) {
    val main = item.main
    val weather = item.weather.first()

    Column(
        modifier = modifier
            .padding(bottom = 8.dp)
    ) {
        ListItem(
            modifier = modifier
                .height(70.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            leadingContent = {
            Image(
            painter = painterResource(id = ImageHelper().iconWeather(weather.icon)),
            contentDescription = item.dt.toString(),
            contentScale = ContentScale.Crop,
            modifier = modifier.size(50.dp)
        )
//                AsyncImage(
//                    model = "https://openweathermap.org/payload/api/media/file/${weather.icon}@2x.png",
//                    contentDescription = item.dt.toString(),
//                    contentScale = ContentScale.Crop,
//                    modifier = modifier.size(50.dp),
//                    placeholder = painterResource(id = R.drawable.rain_day),
//                    error = painterResource(id = R.drawable.rain_day),
//                    onLoading = {
//                        Log.d("WeatherItem", "Loading")
//                    },
//                    onError = {
//                        Log.d("WeatherItem", "Error : ${it.result}")
//                    }
//                   // loading = painterResource(id = R.drawable.rain_day),
//                )
            },
            headlineContent = {
                Text(
                    text = item.dt_txt,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray
                )
            },
            overlineContent = { Text(text = weather.description) },
            trailingContent = {
                Text(
                    text = "${main.temp}°C",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            },
        )
    }
}
