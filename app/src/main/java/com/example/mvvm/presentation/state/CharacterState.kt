package com.example.mvvm.presentation.state

import com.example.mvvm.domain.model.Characters

data class CharacterState(

    val characters:List<Characters>? = emptyList(),
    val errorMsg:String? = "",
    val isLoading:Boolean = false

)