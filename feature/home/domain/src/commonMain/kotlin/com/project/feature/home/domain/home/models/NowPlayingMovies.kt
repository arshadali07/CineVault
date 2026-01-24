package com.project.feature.home.domain.home.models

data class NowPlayingMovies(
    val dates: NowPlayingMovieDates?,
    val page: Int?,
    val results: List<NowPlayingMovieResult>?,
    val totalPages: Int?,
    val totalResults: Int?
)

data class NowPlayingMovieDates(
    val maximum: String?,
    val minimum: String?
)

data class NowPlayingMovieResult(
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