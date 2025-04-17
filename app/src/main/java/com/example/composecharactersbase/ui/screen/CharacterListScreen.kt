package com.example.composecharactersbase.ui.screen

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.composecharactersbase.ui.components.CharacterCard
import com.example.composecharactersbase.viewmodel.CharacterViewModel

@Composable
fun CharacterListScreen(navController: NavController, context: Context) {
    val viewModel = CharacterViewModel()

    val characters by viewModel.characters.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(characters) { character ->
            CharacterCard(character = character, context = context)
        }
    }
}
