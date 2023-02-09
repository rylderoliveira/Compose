package com.impacta.compose.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                StyledTextField()
            }
        }
    }
}

@Preview
@Composable
fun StyledTextField() {
    val text = remember { mutableStateOf("") }
    val colorAccent = Color.Blue
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
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
            bottomStart = 20.dp,
            bottomEnd = 20.dp
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