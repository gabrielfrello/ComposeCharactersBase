package com.example.composecharactersbase.repository

import com.example.composecharactersbase.api.RetrofitClient
import com.example.composecharactersbase.model.Character

class CharacterRepository {
    suspend fun getCharacters(): List<Character> {
        return RetrofitClient.apiService.getCharacters()
    }
}
