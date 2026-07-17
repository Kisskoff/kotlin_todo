package com.formation.todolist.ui.view.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.formation.todolist.R
import com.formation.todolist.ui.theme.TodoListTheme

@Composable
fun LinkedInScreen(modifier: Modifier = Modifier) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primaryContainer,
            // MaterialTheme.colorScheme.primaryContainer,
            Color.White
        ),
        // start = Offset.Zero,
        // end = Offset.Infinite // Direction par défaut (en bas à droite)
    )


    Column(
        modifier = modifier
            .background(gradient)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Avatar()
        //nom et prenom
        Text(text = "Kouakou Yaya, grow your network faster",fontWeight = FontWeight.Bold, fontSize = 25.sp)
        //sous titre
        //Text(text = "Développeur Android")
        //
        Text(text = "Premium Subscribers get 4x more profile views, 3x more messages, and 3x more job opportunities.", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
//
        Text(
            text = buildAnnotatedString {

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Plus!")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W200,
                    )
                ){
                append(" Join exclusive conversations with influential business leaders.")}
            }
        )

        Row(
          //  modifier = Modifier.background(color = Color.Blue),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MoreImage()
            Text(
                text = "Adriel and millions of other members use Premium.",
                fontSize = 12.sp,
                color = Color.LightGray,
            )
        }

        // spacer
        Spacer(modifier = Modifier.weight(1.0f))
        // bottom
        Text(text = buildAnnotatedString {

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("1-month free.")
            }
            append(" Easy to cancel. No penalities or fees.")
        })
        //spacer
       // Spacer(modifier = Modifier.weight(1.0f))
        //button
        Button(
            onClick = { /* TODO */ }) {
            Text(text = "Try Premium for F CFA 0", fontWeight = FontWeight.Bold)
        }

        //
        TextButton(
            onClick = { /* TODO */ }
        ) {
            Text(text = "No thanks")
        }
    }
}

@Composable
fun MoreImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
         //.background(color = Color.Red)
         .width(70.dp),
       // propagateMinConstraints = true,

    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "pr1",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .offset(x = 0.dp)
                .size(30.dp)
                .border(1.dp, Color.White, CircleShape)
            ,
        )
        Image(
            painter = painterResource(id = R.drawable.social),
            contentDescription = "pr1",
            contentScale = ContentScale.Fit,
            modifier = Modifier
               // .clip(CircleShape)
               .offset(x = 18.dp)
                .size(30.dp)
                .border(1.dp, Color.White, CircleShape),
        )
        Image(
            painter = painterResource(id = R.drawable.social),
            contentDescription = "pr1",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                //.clip(CircleShape)
                .offset(x = 36.dp)
                .size(30.dp)
                .border(1.dp, Color.White, CircleShape),
        )
    }
}

@Composable
private fun Avatar() {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.BottomEnd,

        ) {
//        Surface(
//            shape = CircleShape,
//            color = MaterialTheme.colorScheme.primaryContainer,
//            border = BorderStroke(width = 4.dp, color = Color.White)
//        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Avatar",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(150.dp)
                    .border(6.dp, Color.Blue, CircleShape)
            )
      //  }
        Image(
            painter = painterResource(id = R.drawable.linkedin),
            contentDescription = "link",
            modifier = Modifier
                .size(35.dp)
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun AvatarPreview() {

    TodoListTheme {
        LinkedInScreen()
    }

}