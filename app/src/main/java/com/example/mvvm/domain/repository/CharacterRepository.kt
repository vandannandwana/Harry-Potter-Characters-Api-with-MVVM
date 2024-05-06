package com.example.mvvm.domain.repository

import com.example.mvvm.core.common.Resource
import com.example.mvvm.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacters(): Flow<Resource<List<Characters>>>

}