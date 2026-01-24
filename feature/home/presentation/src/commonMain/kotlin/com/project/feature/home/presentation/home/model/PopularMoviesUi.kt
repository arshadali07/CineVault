package com.project.feature.home.presentation.home.model

data class PopularMoviesUi(
    val page: Int?,
    val results: List<PopularMovieResultUi>?,
    val totalPages: Int?,
    val totalResults: Int?
)

data class PopularMovieResultUi(
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: List<Int>?,
    val id: Int?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
)