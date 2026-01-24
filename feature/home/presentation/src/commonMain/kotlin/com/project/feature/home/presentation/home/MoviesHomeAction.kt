package com.project.feature.home.presentation.home

sealed interface MoviesHomeAction {
    data object OnBackClickAction : MoviesHomeAction
}