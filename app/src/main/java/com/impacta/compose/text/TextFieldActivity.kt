package com.impacta.compose.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a = mutableStateOf(1)
        setContent {
            Column {
                SimpleEmailInput(a.value)
                Divider(color = Color.Gray)
                ColoredEmailInput(Color.Blue)
                ColoredEmailInput(Color.Red)
                ColoredEmailInput(Color.Magenta)
                ColoredEmailInput(Color.Green)
                Divider(color = Color.Gray)
                RoundedNameInput()
                Divider(color = Color.Gray)
                RoundedNameInput(Color.Red)
            }
        }
    }
}

@Composable
fun ColoredEmailInput(colorAccent: Color, hasBottomIndicator: Boolean = false) {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxWidth(),
        label = {
            Text(text = "Email")
        },
        placeholder = {
            Text(
                text = "Digite seu email",
                color = colorAccent
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email icon"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorAccent.copy(
                TextFieldDefaults.BackgroundOpacity
            ),
            focusedLabelColor = colorAccent,
            unfocusedLabelColor = colorAccent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            leadingIconColor = colorAccent.copy(
                TextFieldDefaults.IconOpacity
            ),
            cursorColor = colorAccent,
            textColor = colorAccent
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}

@Composable
fun SimpleEmailInput(
    a: Int,
) {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxWidth(),
        label = {
            Text(text = "Email")
        },
        placeholder = {
            Text(
                text = "Digite seu email",
            )
        }
    )
}

@Composable
fun RoundedNameInput(colorAccent: Color? = null) {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = {
            Text(text = "Name")
        },
        placeholder = {
            Text(
                text = "Digite seu nome",
                color = colorAccent ?: Color.Black
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "Name icon"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorAccent?.copy(
                TextFieldDefaults.BackgroundOpacity
            ) ?: Color.Gray.copy(TextFieldDefaults.BackgroundOpacity),
            focusedLabelColor = colorAccent ?: Color.Black,
            unfocusedLabelColor = colorAccent ?: Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            leadingIconColor = colorAccent?.copy(
                TextFieldDefaults.IconOpacity
            ) ?: Color.Gray.copy(TextFieldDefaults.IconOpacity),
            cursorColor = colorAccent ?: Color.Gray,
            textColor = colorAccent ?: Color.Black
        ),
        shape = CutCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        )
    )
}