package com.jetpackcomposecourse

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _uiState = mutableStateOf(UIState())
    val state : State<UIState> = _uiState

    sealed class UIEvent{
        object IncrementCounter : UIEvent()
        class ChooseButton(number : Int) : UIEvent()
    }

    fun onEvent(event : UIEvent){
          when(event){
              UIEvent.IncrementCounter ->{
                _uiState.value = state.value.copy(
                    counter = state.value.counter+1
                )
              }

              is UIEvent.ChooseButton -> {
                  _uiState.value = state.value.copy(
                      buttonNumber = state.value.buttonNumber+1
                  )
              }
          }
    }
    data class UIState(
        val counter : Int = 0,
        val buttonNumber : Int =1
    )
}

