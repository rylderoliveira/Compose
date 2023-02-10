package com.impacta.compose.button

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun SimpleButton(context: Context) {
    Button(
        onClick = {
            Toast.makeText(
                context,
                "Botão Clicado",
                Toast.LENGTH_LONG
            ).show()
        }
    ) {
        Text(text = "Button")
    }
}