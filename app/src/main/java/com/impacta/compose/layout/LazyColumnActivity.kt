package com.impacta.compose.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.impacta.compose.text.Curiosity
import com.impacta.compose.text.StyledText

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val curiosities = listOf<Curiosity>(
                Curiosity("Title 1", "Descrição 1"),
                Curiosity("Title 2", "Descrição 2"),
                Curiosity("Title 3", "Descrição 3"),
                Curiosity("Title 4", "Descrição 4"),
            )
            LazyColumnCuriosities(curiosities = curiosities)
        }
    }
}

@Preview
@Composable
fun LazyColumnCuriosities(
    @PreviewParameter(CuriositiesProvider::class)
    curiosities: List<Curiosity>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(curiosities) { curiosity ->
            Column {
                StyledText(text = curiosity.title, style = TextStyle.Default)
                StyledText(text = curiosity.description, style = TextStyle.Default)
            }
        }
    }
}