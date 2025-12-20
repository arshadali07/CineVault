package com.project.feature.movies.presentation.movies

sealed interface MoviesAction {
    data object OnBackClickAction : MoviesAction
}