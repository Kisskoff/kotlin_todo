package com.formation.todolist.ui.view.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.formation.todolist.R
import com.formation.todolist.ui.theme.TodoListTheme
import com.formation.todolist.viewModel.AlienViewModel

@Composable
fun SettingScreen(modifier: Modifier = Modifier, vm: AlienViewModel = viewModel()) {

    val alienSate by vm.state.collectAsState()

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
                .blur(radius = 50.dp)
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.alienbg),
            contentScale = ContentScale.Crop,
            contentDescription = "Alien",
        )
        Column(
            modifier = modifier
                .padding(16.dp),
           verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Alien Attack", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1.0f))
            //
            Row(
                modifier = Modifier
                    .fillMaxWidth()

                   // .background(color = Color.Blue)

                    .height(inDP)
            ) {
                Spacer(modifier = Modifier
                    .background(color = Color.Red)
                    .width((twoThird * alienSate.position).dp))
                Image(
                    painter = painterResource(id = alienSate.image),
                    modifier = Modifier
                        .clickable(onClick = {
                            vm.onCancel() }
                        )
                        .size(inDP),
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
                if(!alienSate.isActive){
                Button(
                    onClick = {
                        vm.onStart()
                    },
                    content = {Text(text= "Start")},
                   // enabled = !alienSate.isActive
                )}
                if(alienSate.isActive){
                Button(
                    onClick = {
                        vm.onCancel()
                    },
                    content = {Text(text= "Cancel")},
                   // enabled = alienSate.isActive

                )}
                if(!alienSate.isActive && alienSate.distance == 0){
                Button(
                    onClick = {
                        vm.onReset()
                    },
                    content = {Text(text= "Reset")},
                   // enabled = (alienSate.isActive && alienSate.distance == 0)
                )}
            }
        }
    }
}

@Preview
@Composable
private fun SettingScreenPreview() {
    TodoListTheme {
        SettingScreen()
    }

}