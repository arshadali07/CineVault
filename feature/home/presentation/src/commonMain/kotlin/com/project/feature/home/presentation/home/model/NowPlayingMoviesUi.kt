package com.project.feature.home.presentation.home.model

data class NowPlayingMoviesUi(
    val dates: NowPlayingMovieDatesUi?,
    val page: Int?,
    val results: List<NowPlayingMovieResultUi>?,
    val totalPages: Int?,
    val totalResults: Int?
)

data class NowPlayingMovieDatesUi(
    val maximum: String?,
    val minimum: String?
)

data class NowPlayingMovieResultUi(
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