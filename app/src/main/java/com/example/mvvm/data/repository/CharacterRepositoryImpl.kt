package com.example.mvvm.data.repository

import com.example.mvvm.core.common.Resource
import com.example.mvvm.data.api.CharacterApi
import com.example.mvvm.data.mapper.toDomainCharacter
import com.example.mvvm.domain.model.Characters
import com.example.mvvm.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi):CharacterRepository {
    override fun getAllCharacters(): Flow<Resource<List<Characters>>> = flow {

        emit(Resource.Loading())

        val result = characterApi.getAllCharacters().map {
            it.toDomainCharacter()
        }
        emit(Resource.Success(result))


    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }


}