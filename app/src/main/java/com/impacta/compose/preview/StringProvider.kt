package com.impacta.compose.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class StringProvider : PreviewParameterProvider<List<String>> {

    override val values: Sequence<List<String>>
        get() = sequenceOf(
            listOf(
                "Hello",
                "World",
                "Hey"
            )
        )

}