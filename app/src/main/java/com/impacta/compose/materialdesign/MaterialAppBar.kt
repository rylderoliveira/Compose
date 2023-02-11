package com.impacta.compose.materialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MaterialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TopAppBarComponent()
                Divider(color = Color.Gray)
                BottomAppBarComponent()
            }
        }
    }
}

@Composable
fun BottomAppBarComponent() {
    BottomAppBar(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
        }
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
        }
    }
}

@Composable
fun TopAppBarComponent() {
    TopAppBar(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        title = { Text("App Name") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
            }
        }
    )
}