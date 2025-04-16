package com.example.composecharactersbase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecharactersbase.repository.CharacterRepository
import com.example.composecharactersbase.model.Character
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class CharacterViewModel : ViewModel() {
    private val _characters = mutableStateOf<List<Character>>(emptyList())
    val characters: State<List<Character>> = _characters

    private val repository = CharacterRepository()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            _characters.value = repository.getCharacters()
        }
    }
}
