package org.sochidrive.weathersd.viewmodel

import org.sochidrive.weathersd.model.Weather

sealed class AppState {
    data class Success(val weatherData: Weather) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}