package com.impacta.compose.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.impacta.compose.text.Curiosity

class CuriositiesProvider: PreviewParameterProvider<List<Curiosity>> {
    override val values: Sequence<List<Curiosity>>
        get() = sequenceOf(
            listOf(
                Curiosity("Curiosidade 1", "Descrição 1"),
                Curiosity("Curiosidade 2", "Descrição 2"),
                Curiosity("Curiosidade 3", "Descrição 3"),
                Curiosity("Curiosidade 4", "Descrição 4"),
                Curiosity("Curiosidade 5", "Descrição 5"),
            )
        )
}