package com.project.feature.home.presentation.home

import com.project.feature.home.presentation.home.model.NowPlayingMoviesUi
import com.project.feature.home.presentation.home.model.NowPlayingTvSeriesUi
import com.project.feature.home.presentation.home.model.PopularMoviesUi

data class MoviesHomeUiState(
    val isApiLoading: Boolean = false,
    val popularMovies: PopularMoviesUi? = null,
    val nowPlayingMovies: NowPlayingMoviesUi? = null,
    val nowPlayingTvSeries: NowPlayingTvSeriesUi? = null
)