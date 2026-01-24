package com.project.feature.home.presentation.home.model

data class NowPlayingTvSeriesUi(
    val page: Int?,
    val results: List<NowPlayingTvSeriesResultUi>?,
    val totalPages: Int?,
    val totalResults: Int?
)

data class NowPlayingTvSeriesResultUi(
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