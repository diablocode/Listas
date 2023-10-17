package com.example.listas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listas.ui.theme.ListasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Listas()
                }
            }
        }
    }
}

@Composable
fun Listas() {
    var isExpanded by remember { mutableStateOf(false) }
    var paisSeleccionado by remember { mutableStateOf("") }
    var listaDePaises = listOf(
        "Honduras",
        "Alemania",
        "Venezuela",
        "Cuba",
        "Lituania",
        "Perú",
        "Haití",
        "México",
        "Nicaragua",
        "Colombia",
        "Estados Unidos de América")
    Column {
        Button(onClick = { isExpanded = !isExpanded }) {
            Text(text = "Mostrar países")
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
                paisSeleccionado = ""
            }
        ) {
            listaDePaises.forEach {
                DropdownMenuItem(
                    text = { Text(text = it) },
                    onClick = { paisSeleccionado = it; isExpanded = false })
            }
        }
        Text(text = paisSeleccionado)
    }
}

@Preview(showBackground = true)
@Composable
fun ListasPreview() {
    ListasTheme {
        Listas()
    }
}