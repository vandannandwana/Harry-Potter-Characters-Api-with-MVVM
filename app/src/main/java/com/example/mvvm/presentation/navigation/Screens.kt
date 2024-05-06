package com.example.mvvm.presentation.navigation

sealed class Screens(val route: String){

    object CharacterScreen:Screens("character_screen")

}