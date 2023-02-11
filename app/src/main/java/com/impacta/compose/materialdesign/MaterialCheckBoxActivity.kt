package com.impacta.compose.materialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MaterialCheckBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column {
                SimpleCheckboxComponent()
                Divider(color = Color.Gray)
                ColoredCheckboxComponent()
                Divider(color = Color.Gray)
                TriStateCheckboxComponent()
            }

        }
    }
}

@Preview
@Composable
fun SimpleCheckboxComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        Checkbox(
            checked = checkedState.value,
            modifier = Modifier.padding(16.dp),
            onCheckedChange = { checkedState.value = it },
        )
        Text(text = "Checkbox Example", modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun ColoredCheckboxComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        Checkbox(
            checked = checkedState.value,
            modifier = Modifier.padding(16.dp),
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White,
            )
        )
        Text(text = "Checkbox Example with color", modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun TriStateCheckboxComponent() {
    val toggleableState =
        listOf(
            ToggleableState.Off,
            ToggleableState.On,
            ToggleableState.Indeterminate
        )
    var counter by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TriStateCheckbox(
            state = toggleableState[counter % 3],
            onClick = {
                counter++
            })
        Text(text = "Checkbox tri-state example", modifier = Modifier.padding(start = 16.dp))
    }
}