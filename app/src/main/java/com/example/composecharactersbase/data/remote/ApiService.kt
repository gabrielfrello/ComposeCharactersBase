package com.example.composecharactersbase.data.remote

import com.example.composecharactersbase.data.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/character")
    suspend fun getCharacters(): Response<CharacterResponse>
}
