package com.example.composecharactersbase.api

import com.example.composecharactersbase.model.Character
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<List<Character>>
}