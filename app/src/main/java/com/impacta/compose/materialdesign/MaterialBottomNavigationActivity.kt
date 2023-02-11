package com.impacta.compose.materialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MaterialBottomNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                BottomNavigationWithLabelComponent()
                Divider(color = Color.Gray)
                BottomNavigationWithoutLabelComponent()
            }
        }
    }
}


@Composable
fun BottomNavigationWithLabelComponent() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Blogs", "Profile")
    BottomNavigation(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.Yellow
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                label = { Text(text = item) },
                icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = "") },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@Composable
fun BottomNavigationWithoutLabelComponent() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Blogs", "Profile")
    BottomNavigation(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.Yellow
    ) {
        BottomNavigationItem(
            label = { Text(text = items[0]) },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "") },
            selected = selectedItem == 0,
            onClick = { selectedItem = 0 },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            label = { Text(text = items[1]) },
            icon = { Icon(imageVector = Icons.Filled.Face, contentDescription = "") },
            selected = selectedItem == 1,
            onClick = { selectedItem = 1 },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            label = { Text(text = items[2]) },
            icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = "") },
            selected = selectedItem == 2,
            onClick = { selectedItem = 2 },
            alwaysShowLabel = false
        )
    }
}