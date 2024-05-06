package com.example.mvvm.domain.usecase

import com.example.mvvm.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: CharacterRepository) {

    operator fun invoke() = repository.getAllCharacters()

}