package com.example.mvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.core.common.Resource
import com.example.mvvm.domain.usecase.GetAllCharactersUseCase
import com.example.mvvm.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: GetAllCharactersUseCase):ViewModel() {

    private val _characters = MutableStateFlow(CharacterState())
    val characters: StateFlow<CharacterState>
        get() = _characters


    init {
        getAllCharacters()
    }

    private fun  getAllCharacters(){
        useCase.invoke().onEach {

            when(it){
                is Resource.Success -> {

                    _characters.value = CharacterState().copy(characters = it.data)

                }
                is Resource.Loading -> {

                    _characters.value = CharacterState().copy(isLoading = true)

                }
                is Resource.Error ->{
                    _characters.value = CharacterState().copy(errorMsg = it.message)
                }
            }
        }.launchIn(viewModelScope)
    }

}