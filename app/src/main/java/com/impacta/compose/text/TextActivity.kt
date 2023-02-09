package com.impacta.compose.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun StyledText(text: String, style: TextStyle) {
    Text(
        text = text,
        style = style,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun StyledText(text: AnnotatedString, style: TextStyle) {
    Text(
        text = text,
        style = style,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun MyApp() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .verticalScroll(
                state = ScrollState(
                    initial = 0
                ),
                enabled = true
            )
    ) {

        StyledText(
            text = "Ola 2",
            style = TextStyle.Default
        )
        StyledText(
            text = "Ola 1",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        StyledText(
            text = "Eu sou um text com fonte bold",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        StyledText(
            text = "Eu sou um texto com a fonte vermelha",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        )
        StyledText(
            text = "Eu sou um texto com a fonte cursiva",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Unspecified,
                fontFamily = FontFamily.Cursive
            )
        )
        StyledText(
            text = "Eu sou um texto underline",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Unspecified,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.LineThrough,
            )
        )
        StyledText(
            text = "Eu sou um texto com sombras",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Unspecified,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.None,
                shadow = Shadow(
                    color = Color.Blue,
                    blurRadius = 8f,
                    offset = Offset(
                        x = 20f,
                        y = -20f,
                    )
                )
            )
        )



        StyledText(
            text = "Eu sou um texto com background amarelo",
            style = TextStyle(
                background = Color.Yellow
            )
        )
        StyledText(
            text = "Eu sou um texto com background amarelo indentado" +
                "Eu sou um texto com background amarelo indentado" +
                "Eu sou um texto com background amarelo indentado" +
                "Eu sou um texto com background amarelo indentado",
            style = TextStyle(
                background = Color.Yellow,
                textIndent = TextIndent(30.sp)
            )
        )
        StyledText(
            text = "Eu sou um texto com background amarelo" +
                "Eu sou um texto com background amarelo" +
                "Eu sou um texto com background amarelo" +
                "Eu sou um texto com background amarelo",
            style = TextStyle(
                background = Color.Yellow,
                textIndent = TextIndent(30.sp, 10.sp)
            )
        )

        val spannable = buildAnnotatedString {
            append("Eu sou o Rylder")
            addStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                start = 9,
                end = 15
            )
        }
        StyledText(
            text = spannable,
            style = TextStyle.Default
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red,
            )
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red
            )
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red
            )
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red
            )
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red
            )
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red
            )
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red
            )
        )
        StyledText(
            text = spannable,
            style = TextStyle(
                background = Color.Red
            )
        )
    }
}