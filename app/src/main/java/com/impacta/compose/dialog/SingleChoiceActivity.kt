package com.impacta.compose.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.util.Locale

val dialogState by lazy { mutableStateOf(false) }
val selectedCountry by lazy { mutableStateOf("") }

val countriesList = getCountries().values.toList()

class SingleChoiceDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesDialog()
            SingleChoiceDialogActivityContent()
        }
    }
}

@Preview
@Composable
fun SingleChoiceDialogActivityContent() {
    Column {
        Button(
            onClick = {
                dialogState.value = true
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = "Show Countries List",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        Divider(color = Color.Black)
        Text(
            text = selectedCountry.value,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

@Composable
fun CountriesDialog() {
    SingleSelectDialog(
        dialogState = dialogState,
        title = "Choose your Country",
        optionsList = countriesList,
        submitButtonText = "Select",
        onSubmitButtonClick = { selectedCountry.value = countriesList[it] },
        onDismissRequest = { dialogState.value = false }
    )
}

@Composable
fun SingleSelectDialog(
    dialogState: MutableState<Boolean>,
    title: String,
    optionsList: List<String>,
    defaultSelected: Int = -1,
    submitButtonText: String,
    onSubmitButtonClick: (Int) -> Unit,
    onDismissRequest: () -> Unit,
) {
    if (dialogState.value) {
        SingleSelectDialog(
            title = title,
            optionsList = optionsList,
            defaultSelected = defaultSelected,
            submitButtonText = submitButtonText,
            onSubmitButtonClick = onSubmitButtonClick,
            onDismissRequest = onDismissRequest
        )
    }
}

@Composable
fun SingleSelectDialog(
    title: String,
    optionsList: List<String>,
    defaultSelected: Int = -1,
    submitButtonText: String,
    onSubmitButtonClick: (Int) -> Unit,
    onDismissRequest: () -> Unit,
) {
    val selectedOption = remember { mutableStateOf(defaultSelected) }
    Dialog(onDismissRequest = { onDismissRequest.invoke() }) {
        Surface(
            modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = title)
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier.height(500.dp)
                ) {
                    items(optionsList) {
                        val selected = if (selectedOption.value == -1) {
                            ""
                        } else {
                            optionsList[selectedOption.value]
                        }
                        TextRadioButton(it, selected) { selectedValue ->
                            selectedOption.value = optionsList.indexOf(selectedValue)
                        }
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {
                        onSubmitButtonClick.invoke(selectedOption.value)
                        onDismissRequest.invoke()
                    },
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = submitButtonText)
                }
            }

        }
    }
}

@Composable
fun TextRadioButton(text: String, selectedValue: String, onClickListener: (String) -> Unit) {
    Row(Modifier
        .fillMaxWidth()
        .selectable(
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            }
        )
        .padding(horizontal = 16.dp)
    ) {
        RadioButton(
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            }
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

// Dummy Util function for the sake of example
fun getCountries(): Map<String, String> {
    val countriesMap = hashMapOf<String, String>()
    val isoCountries = Locale.getISOCountries()
    isoCountries.forEach {
        val locale = Locale("", it)
        countriesMap[locale.country.lowercase(Locale.getDefault())] = locale.displayCountry
    }
    return countriesMap.toList().sortedBy { (_, value) -> value }.toMap()
}