package com.impacta.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.impacta.compose.layout.LazyColumnActivity
import com.impacta.compose.text.TextActivity
import com.impacta.compose.text.TextFieldActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = TextActivity::class.java,
                    title = "Texts"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = TextFieldActivity::class.java,
                    title = "TextFields"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = LazyColumnActivity::class.java,
                    title = "Lazy Column"
                )
            }
        }
    }
}

@Composable
fun ButtonMain(
    context: Context,
    nextActivity: Class<out ComponentActivity>,
    title: String,
) {
    Button(
        onClick = {
            with(context) {
                val intent = Intent(this, nextActivity)
                startActivity(intent)
            }
        },
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = title)
    }
}