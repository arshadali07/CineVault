package com.project.feature.movies.domain.movies.models

data class Movies(
    val page: Int?,
    val results: List<MoviesResult>?,
    val totalPages: Int?,
    val totalResults: Int?
)

data class MoviesResult(
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