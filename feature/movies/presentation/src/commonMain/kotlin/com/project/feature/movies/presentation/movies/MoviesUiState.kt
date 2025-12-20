package com.project.feature.movies.presentation.movies

import com.project.feature.movies.presentation.movies.models.MoviesUi

data class MoviesUiState(
    val isApiLoading: Boolean = false,
    val movies: MoviesUi? = null
)