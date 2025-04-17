package com.example.composecharactersbase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecharactersbase.data.model.Character
import com.example.composecharactersbase.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> get() = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getCharacters()
            if (response.isSuccessful) {
                _characters.value = response.body()?.results ?: emptyList()
            }
        }
    }
}
