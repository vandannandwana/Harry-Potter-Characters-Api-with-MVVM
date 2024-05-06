package com.example.mvvm.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mvvm.presentation.state.CharacterState

@Composable
fun CharacterScreen(modifier: Modifier,characterState:CharacterState){

    if(characterState.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }else if(characterState.errorMsg?.isEmpty() == true){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = characterState.errorMsg.toString())
        }
    }

    if(characterState.characters?.isNotEmpty() == true){
        LazyColumn {
            items(characterState.characters){
                CharacterItem(modifier = modifier, character = it)
            }
        }
    }

}