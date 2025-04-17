package com.example.composecharactersbase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.composecharactersbase.ui.screen.CharacterListScreen
import com.example.composecharactersbase.ui.theme.ComposeCharactersBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCharactersBaseTheme {
                val navController = rememberNavController()
                CharacterListScreen(navController = navController, context = this)
            }
        }
    }
}
