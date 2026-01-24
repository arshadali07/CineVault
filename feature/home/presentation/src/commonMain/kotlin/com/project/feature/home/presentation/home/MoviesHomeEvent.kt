package com.project.feature.home.presentation.home

sealed interface MoviesHomeEvent {
    data class ShowToatEvent(val message: String) : MoviesHomeEvent
}