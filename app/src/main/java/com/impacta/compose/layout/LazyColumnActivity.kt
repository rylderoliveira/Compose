package com.impacta.compose.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.impacta.compose.text.Curiosity
import java.util.Random

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val curiosities = listOf<Curiosity>(
                Curiosity("Title 1", "Descrição 1"),
                Curiosity("Title 2", "Descrição 2"),
                Curiosity("Title 3", "Descrição 3"),
                Curiosity("Title 4", "Descrição 4"),
                Curiosity("Title 1", "Descrição 1"),
                Curiosity("Title 2", "Descrição 2"),
                Curiosity("Title 3", "Descrição 3"),
                Curiosity("Title 4", "Descrição 4"),
                Curiosity("Title 1", "Descrição 1"),
                Curiosity("Title 2", "Descrição 2"),
                Curiosity("Title 3", "Descrição 3"),
                Curiosity("Title 4", "Descrição 4"),
                Curiosity("Title 1", "Descrição 1"),
                Curiosity("Title 2", "Descrição 2"),
                Curiosity("Title 3", "Descrição 3"),
                Curiosity("Title 4", "Descrição 4"),
            )
            SimpleLazyColumn(list = curiosities)
        }
    }
}

@Preview
@Composable
fun SimpleLazyColumn(
    @PreviewParameter(provider = CuriositiesProvider::class)
    list: List<Curiosity>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(list) { curiosity ->
            BoxCuriosity(
                title = curiosity.title,
                description = curiosity.description,
            )
        }
    }
}

@Composable
fun BoxCuriosity(title: String, description: String) {
    val randomColor = Color(
        red = Random().nextInt(255),
        blue = Random().nextInt(255),
        green = Random().nextInt(255)
    )
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(randomColor)
            .width(150.dp)
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Column {
            Text(text = title)
            Text(text = description)
        }
    }
}