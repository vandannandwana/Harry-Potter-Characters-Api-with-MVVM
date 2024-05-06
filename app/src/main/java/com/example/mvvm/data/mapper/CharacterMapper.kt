package com.example.mvvm.data.mapper

import com.example.mvvm.data.dto.CharactersDto
import com.example.mvvm.domain.model.Characters

fun CharactersDto.toDomainCharacter(): Characters{
    return Characters(actor, id, image,name)
}