package com.impacta.compose.materialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MaterialProgressBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleCircularProgressComponent()
                CircularProgressComponent()
                SimpleLinearProgressComponent()
                LinearProgressComponent()
            }
        }
    }
}

@Preview
@Composable
fun SimpleCircularProgressComponent() {
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp)
    )
}

@Preview
@Composable
fun CircularProgressComponent() {
    val progress by remember { mutableStateOf(0.6f) }
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp),
        progress = progress,
        color = Color.Green
    )
}

@Preview
@Composable
fun SimpleLinearProgressComponent() {
    LinearProgressIndicator(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun LinearProgressComponent() {
    LinearProgressIndicator(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        progress = 0.7f,
        color = Color.Green
    )
}