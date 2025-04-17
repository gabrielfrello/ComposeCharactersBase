package com.example.composecharactersbase.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CharacterDetailScreen(characterId: Int) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Detalhes do personagem", modifier = Modifier.padding(bottom = 8.dp))

        Text(text = "ID: $characterId", modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Nome do Personagem", modifier = Modifier.padding(bottom = 8.dp))

        Image(
            painter = rememberAsyncImagePainter(model = "https://rickandmortyapi.com/api/character/avatar/$characterId.jpeg"),
            contentDescription = "Character image",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Preview
@Composable
fun PreviewCharacterDetailScreen() {
    CharacterDetailScreen(characterId = 1)
}
