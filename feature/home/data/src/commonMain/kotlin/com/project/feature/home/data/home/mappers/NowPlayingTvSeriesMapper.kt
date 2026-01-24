package com.project.feature.home.data.home.mappers

import com.project.core.data.networking.UrlConstants
import com.project.feature.home.data.home.models.NowPlayingTvSeriesDto
import com.project.feature.home.data.home.models.NowPlayingTvSeriesResultDto
import com.project.feature.home.domain.home.models.NowPlayingTvSeries
import com.project.feature.home.domain.home.models.NowPlayingTvSeriesResult
fun NowPlayingTvSeriesDto.toDomain(): NowPlayingTvSeries {
    return NowPlayingTvSeries(
        page = page,
        results = results?.map { it.toDomain() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun NowPlayingTvSeriesResultDto.toDomain(): NowPlayingTvSeriesResult {
    return NowPlayingTvSeriesResult(
        backdropPath = "${UrlConstants.BACKDROP_IMAGE_BASE_URL}$backdropPath",
        firstAirDate = firstAirDate,
        genreIds = genreIds,
        id = id,
        name = name,
        originCountry = originCountry,
        originalLanguage = originalLanguage,
        originalName = originalName,
        overview = overview,
        popularity = popularity,
        posterPath = "${UrlConstants.POSTER_IMAGE_BASE_URL}$posterPath",
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}