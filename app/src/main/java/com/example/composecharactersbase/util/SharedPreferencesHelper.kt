package com.example.composecharactersbase.util

import android.content.Context

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)

    fun addFavorite(characterId: Int) {
        sharedPreferences.edit().putInt(characterId.toString(), characterId).apply()
    }

    fun removeFavorite(characterId: Int) {
        sharedPreferences.edit().remove(characterId.toString()).apply()
    }

    fun isFavorite(characterId: Int): Boolean {
        return sharedPreferences.contains(characterId.toString())
    }
}
