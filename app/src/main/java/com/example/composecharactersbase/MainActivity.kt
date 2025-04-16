package com.example.composecharactersbase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.composecharactersbase.ui.theme.ComposeCharactersBaseTheme
import com.example.composecharactersbase.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeCharactersBaseTheme {
                // Obter o ViewModel e inicializar o NavController
                val viewModel: CharacterViewModel = viewModel()
                val navController = rememberNavController()

                // Chama a função que já está no CharactersApp.kt
                CharacterApp() // Essa função já está implementada e não será modificada
            }
        }
    }
}
