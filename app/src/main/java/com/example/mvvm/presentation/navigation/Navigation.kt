package com.example.mvvm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.presentation.components.CharacterScreen
import com.example.mvvm.presentation.viewmodel.CharactersViewModel

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.CharacterScreen.route){



        composable(Screens.CharacterScreen.route){
            val characterViewModel = hiltViewModel<CharactersViewModel>()
            val characterState = characterViewModel.characters.collectAsStateWithLifecycle().value
            CharacterScreen(modifier = Modifier, characterState = characterState)

        }
    }

}