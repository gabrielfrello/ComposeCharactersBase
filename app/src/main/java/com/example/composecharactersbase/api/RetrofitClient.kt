package com.example.composecharactersbase.api

import com.example.composecharactersbase.model.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): List<Character> // Lista de personagens
}

object RetrofitClient {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
