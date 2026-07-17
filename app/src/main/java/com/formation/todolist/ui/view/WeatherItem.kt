package com.formation.todolist.ui.view

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
import com.formation.todolist.R
import com.formation.todolist.ui.theme.TodoListTheme

@Composable
fun WeatherItem(modifier: Modifier = Modifier) {
    Column(
        modifier =modifier
        .padding(bottom = 8.dp)
    ) {
    ListItem(
        modifier = modifier
            .height(70.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth(),
        leadingContent = { Image(
            painter = painterResource(id = R.drawable.rain_day),
            contentDescription = "Weather",
            contentScale = ContentScale.Crop,
            modifier = modifier.size(50.dp)
        )},
        headlineContent = { Text(text = "17/07/2026 19:43:00",fontStyle = FontStyle.Italic, color = Color.Gray) },
        overlineContent = { Text(text = "Peu nuageux") },
        trailingContent = { Text(text = "20°C", fontWeight = FontWeight.Bold, fontSize = 17.sp) },
    )}
}

@Preview()
@Composable
private fun WeatherItemPreview() {
  TodoListTheme {
    WeatherItem()
  }
}
