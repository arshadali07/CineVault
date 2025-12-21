package com.project.feature.movies.presentation.movie_detail

import com.project.feature.movies.presentation.movie_detail.models.MovieDetailsUi

data class MovieDetailsUiState(
    val isApiLoading: Boolean = false,
    val movieDetails: MovieDetailsUi? = null
)