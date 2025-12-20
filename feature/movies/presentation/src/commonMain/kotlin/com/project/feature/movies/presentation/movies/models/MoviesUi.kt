package com.project.feature.movies.presentation.movies.models

data class MoviesUi(
    val page: Int?,
    val results: List<MoviesResultUi>?,
    val totalPages: Int?,
    val totalResults: Int?
)

data class MoviesResultUi(
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