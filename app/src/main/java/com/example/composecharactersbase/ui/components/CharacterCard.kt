package com.example.composecharactersbase.ui.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composecharactersbase.data.model.Character
import com.example.composecharactersbase.util.SharedPreferencesHelper
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun CharacterCard(character: Character, context: Context) {
    val sharedPreferencesHelper = SharedPreferencesHelper(context)
    var isFavorite by remember { mutableStateOf(sharedPreferencesHelper.isFavorite(character.id)) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = character.imageUrl),
                contentDescription = "Character Image",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = character.name)
                Text(text = "Status: ${character.status}")
                Text(text = "Species: ${character.species}")
            }

            IconButton(onClick = {
                isFavorite = !isFavorite
                if (isFavorite) {
                    sharedPreferencesHelper.addFavorite(character.id)
                } else {
                    sharedPreferencesHelper.removeFavorite(character.id)
                }
            }) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Star else Icons.Filled.StarBorder,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color.Yellow else Color.Gray
                )
            }
        }
    }
}
