package com.example.mvvm.data.api

import com.example.mvvm.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getAllCharacters():List<CharactersDto>

}