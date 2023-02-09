package com.impacta.compose.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp1()
        }
    }
}

@Preview
@Composable
fun MyApp1() {
    val user = User(
        name = "Rylder Oliveira",
        age = 25,
        city = "Araxá",
        profileImage = "Isso é a imagem de perfil",
        curiosities = listOf(
            Curiosity(
                title = "Curiosidade 1",
                description = "Descrição 1"
            )
        )
    )
    Profile(user = user)
}

@Composable
fun Profile(user: User) {
    Column {
        Header(user = user)
        Divider()
        Buttons()
    }
}

@Composable
fun Buttons() {
    Row {
        Text(text = "Photos")
        Text(text = "Curiosities")
    }
}

@Composable
fun Header(user: User) {
    Column {
        ImageHeader(user.profileImage)
        InfosHeader(user)
    }
}

@Composable
fun InfosHeader(user: User) {
    val infos = buildAnnotatedString {
        append("${user.name}\n${user.age} anos\n${user.city}")
        addStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold
            ),
            start = 0,
            end = user.name.length
        )
    }

    Text(
        text = infos,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    )
}

@Composable
fun ImageHeader(imageHeader: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = imageHeader,
            modifier = Modifier.padding(32.dp),
            color = Color.White
        )
    }
}