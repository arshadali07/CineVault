package com.project.feature.home.presentation.home.mappers

import com.project.feature.home.domain.home.models.NowPlayingTvSeries
import com.project.feature.home.domain.home.models.NowPlayingTvSeriesResult
import com.project.feature.home.presentation.home.model.NowPlayingTvSeriesResultUi
import com.project.feature.home.presentation.home.model.NowPlayingTvSeriesUi

fun NowPlayingTvSeries.toUi(): NowPlayingTvSeriesUi {
    return NowPlayingTvSeriesUi(
        page = page,
        results = results?.map { it.toUi() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun NowPlayingTvSeriesResult.toUi(): NowPlayingTvSeriesResultUi {
    return NowPlayingTvSeriesResultUi(
        backdropPath = backdropPath,
        firstAirDate = firstAirDate,
        genreIds = genreIds,
        id = id,
        name = name,
        originCountry = originCountry,
        originalLanguage = originalLanguage,
        originalName = originalName,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}