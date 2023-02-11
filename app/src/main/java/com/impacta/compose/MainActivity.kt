package com.impacta.compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.impacta.compose.button.ButtonActivity
import com.impacta.compose.card.CardActivity
import com.impacta.compose.clickable.ClickableActivity
import com.impacta.compose.dialog.DialogActivity
import com.impacta.compose.dialog.SingleChoiceDialogActivity
import com.impacta.compose.image.ImageActivity
import com.impacta.compose.layout.BoxActivity
import com.impacta.compose.layout.LazyColumnActivity
import com.impacta.compose.materialdesign.MaterialActivity
import com.impacta.compose.materialdesign.MaterialBottomNavigationActivity
import com.impacta.compose.materialdesign.MaterialCheckBoxActivity
import com.impacta.compose.materialdesign.MaterialProgressBarActivity
import com.impacta.compose.materialdesign.MaterialRadioButtonActivity
import com.impacta.compose.materialdesign.MaterialSliderActivity
import com.impacta.compose.text.TextActivity
import com.impacta.compose.text.TextFieldActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
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
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = ImageActivity::class.java,
                    title = "Image Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = DialogActivity::class.java,
                    title = "Dialog Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = SingleChoiceDialogActivity::class.java,
                    title = "Choice Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = MaterialActivity::class.java,
                    title = "AppBar Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = MaterialBottomNavigationActivity::class.java,
                    title = "Bottom Nav Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = MaterialCheckBoxActivity::class.java,
                    title = "Checkbox Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = MaterialRadioButtonActivity::class.java,
                    title = "Radio Button Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = MaterialProgressBarActivity::class.java,
                    title = "Progress Bar Activity"
                )
                ButtonMain(
                    context = this@MainActivity,
                    nextActivity = MaterialSliderActivity::class.java,
                    title = "Slider Activity"
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