package com.impacta.compose.materialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MaterialSliderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleSliderComponent()
                ColoredSliderComponent()
                SteppedSliderComponent()
            }
        }
    }
}

@Preview
@Composable
fun SimpleSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.4f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            sliderValue = newValue
        }
    )
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Preview
@Composable
fun ColoredSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.4f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            sliderValue = newValue
        },
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTrackColor = Color.Yellow
        )
    )
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Preview
@Composable
fun SteppedSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.5f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        valueRange = 0f..10f,
        steps = 10,
        colors = SliderDefaults.colors(
            activeTickColor = Color.Red,
            inactiveTickColor = Color.Yellow
        ),
        onValueChange = { sliderValue = it })
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}