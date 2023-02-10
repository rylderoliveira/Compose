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
import com.impacta.compose.button.ButtonActivity
import com.impacta.compose.card.CardActivity
import com.impacta.compose.clickable.ClickableActivity
import com.impacta.compose.layout.BoxActivity
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
                    title = "Text Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = TextFieldActivity::class.java,
                    title = "Text Field Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = BoxActivity::class.java,
                    title = "Box Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = LazyColumnActivity::class.java,
                    title = "Lazy Column Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = ButtonActivity::class.java,
                    title = "Button Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = CardActivity::class.java,
                    title = "Card Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = ClickableActivity::class.java,
                    title = "Clickable Activity"
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
            val intent = Intent(context, nextActivity)
            context.startActivity(intent)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = title)
    }
}