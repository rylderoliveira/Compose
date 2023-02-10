package com.impacta.compose.button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                SimpleButtonComponent()
                Divider(color = Color.Gray)

                TextButtonComponent()
                Divider(color = Color.Gray)

                RoundedCornerButtonComponent()
                Divider(color = Color.Gray)

                BorderButtonComponent()
                Divider(color = Color.Gray)

                ButtonWithIconComponent()
                Divider(color = Color.Gray)

                ColoredButtonComponent()
                Divider(color = Color.Gray)

                DisabledButtonComponent()
                Divider(color = Color.Gray)

                OutlinedButtonComponent()
                Divider(color = Color.Gray)

                IconButtonComponent()
                Divider(color = Color.Gray)

                FloatingActionButtonComponent()
                Divider(color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun SimpleButtonComponent() {
    val context = LocalContext.current
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

@Preview
@Composable
fun TextButtonComponent() {
    val context = LocalContext.current
    TextButton(
        onClick = {
            Toast.makeText(
                context,
                "Botão Clicado",
                Toast.LENGTH_LONG
            ).show()
        }
    ) {
        Text(text = "TextButton")
    }
}

@Preview
@Composable
fun RoundedCornerButtonComponent() {
    val context = LocalContext.current
    // shape is used to give the shape to Compose UI elements.
    Button(
        onClick = {
            Toast.makeText(
                context,
                "Botão Clicado",
                Toast.LENGTH_LONG
            ).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text("RoundedCorner")
    }
}

@Preview
@Composable
fun BorderButtonComponent() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(
                context,
                "Botão Clicado",
                Toast.LENGTH_LONG
            ).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Green))
    ) {
        Text("Border")
    }
}

@Preview
@Composable
fun ButtonWithIconComponent() {
    val context = LocalContext.current
    // You can put some icon on the Button by using Icon Composable.
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green))
    ) {
        Text("Icon Button")
        Icon(imageVector = Icons.Filled.Face, "Icone")
    }
}

@Preview
@Composable
fun ColoredButtonComponent() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "You clicked me :(", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta
        )
    ) {
        Icon(imageVector = Icons.Filled.Favorite, "Icone")
        Text("Click Me")
        Icon(imageVector = Icons.Filled.Favorite, "Icone")
    }
}

@Preview
@Composable
fun DisabledButtonComponent() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        enabled = false
    ) {
        Text("Click Me")
        Icon(imageVector = Icons.Filled.Favorite, "Icone")
    }
}

@Preview
@Composable
fun OutlinedButtonComponent() {
    val context = LocalContext.current
    // OutlinedButton is used for actions that are important but are not the primary action
    // in the app. For example, in Google Play Store, Uninstall is an important action but
    // not the primary action of the Play Store.
    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Text("Click Me")
        Icon(imageVector = Icons.Filled.Favorite, "Icone")
    }
}

@Preview
@Composable
fun IconButtonComponent() {
    val context = LocalContext.current
    // Icons can also be used as a button by using the IconButton composable.
    IconButton(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Icon(imageVector = Icons.Filled.Favorite, "Icone")
    }
}

@Preview
@Composable
fun FloatingActionButtonComponent() {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(imageVector = Icons.Filled.Favorite, "Icone")
    }
}