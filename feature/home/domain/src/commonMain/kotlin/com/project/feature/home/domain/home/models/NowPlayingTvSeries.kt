package com.project.feature.home.domain.home.models

data class NowPlayingTvSeries(
    val page: Int?,
    val results: List<NowPlayingTvSeriesResult>?,
    val totalPages: Int?,
    val totalResults: Int?
)

data class NowPlayingTvSeriesResult(
    val backdropPath: String?,
    val firstAirDate: String?,
    val genreIds: List<Int>?,
    val id: Int?,
    val name: String?,
    val originCountry: List<String>?,
    val originalLanguage: String?,
    val originalName: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val voteAverage: Double?,
    val voteCount: Int?
)