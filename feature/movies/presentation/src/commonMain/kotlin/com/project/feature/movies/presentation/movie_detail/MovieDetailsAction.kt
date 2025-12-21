package com.project.feature.movies.presentation.movie_detail

sealed interface MovieDetailsAction {
    data object OnBackClickAction : MovieDetailsAction
}