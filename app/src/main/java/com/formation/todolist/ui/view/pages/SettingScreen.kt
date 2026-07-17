package com.formation.todolist.ui.view.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.formation.todolist.R
import java.security.AllPermission

@Composable
fun SettingScreen(modifier: Modifier = Modifier) {

    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val third = screenWidth / 3
    val twoThird = screenWidth - third
    val inDP = third.dp

    Box(
        contentAlignment = Alignment.Center,
    ) {

        Image(
            modifier = Modifier
                .blur(radius = 20.dp)
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.alienbg),
            contentScale = ContentScale.Crop,
            contentDescription = "Alien",
        )
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(text = "Alien Attack", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            //
            Row(
                modifier = Modifier.height(inDP)
            ) {
                Spacer(modifier = Modifier.width(twoThird.dp))
                Image(
                    painter = painterResource(id = R.drawable.alien0),
                    modifier = Modifier.size(inDP),
                    contentDescription = "Alien",
                )
            }
            Spacer(modifier = Modifier.weight(1.0f))
///
            Row(
             modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = {},
                    content = {Text(text= "Start")}
                )
                Button(
                    onClick = {},
                    content = {Text(text= "Cancel")}
                )
                Button(
                    onClick = {},
                    content = {Text(text= "Reset")}
                )
            }
        }
    }
}