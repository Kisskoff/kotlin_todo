package com.formation.todolist.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
@Composable
fun SearchTextFieldExample() {
    val state = rememberTextFieldState()


    TextField(
        value = state,
        modifier = Modifier.fillMaxWidth(),
        accessibilityLabel = "Search",
//        placeholder = { Text("Search...") },
//        leadingIcon = {
//            Icon(
//                imageVector = Icons.Filled.Search,
//                contentDescription = null,
//                modifier = Modifier.size(16.dp),
//              //  tint = Theme[colors][mutedColor],
//            )
//        },
//        trailingIcon = {
//            AnimatedVisibility(
//                visible = state.text.isNotEmpty(),
//                enter = fadeIn(),
//                exit = fadeOut(),
//
//            ) {
//                IconButton(
//                    onClick = { state.clearText() },
//                    modifier = Modifier.size(32.dp),
//                   // style = ButtonStyle.Ghost,
//                   // buttonSize = ButtonSize.Small,
//                ) {
//                    Icon(
//                        imageVector = Icons.Filled.Search,
//                        contentDescription = "Clear search",
//                        modifier = Modifier.size(14.dp),
//                       // tint = Theme[colors][mutedColor],
//                    )
//                }
//            }
//        },
    )

}