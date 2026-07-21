package com.formation.todolist.ui.uiState

import com.formation.todolist.model.WeatherResponse

interface WeatherUIState {
    object LOADING :WeatherUIState
    data class ERROR(val error: String) :WeatherUIState
    data class SUCCES(val forecast: WeatherResponse): WeatherUIState
}