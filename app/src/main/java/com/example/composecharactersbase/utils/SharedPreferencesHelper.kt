package com.example.composecharactersbase.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("favorites", Context.MODE_PRIVATE)

    fun saveFavorite(characterId: Int) {
        sharedPreferences.edit().putInt(characterId.toString(), characterId).apply()
    }

    fun getFavorites(): Set<String> {
        return sharedPreferences.all.keys
    }
}
