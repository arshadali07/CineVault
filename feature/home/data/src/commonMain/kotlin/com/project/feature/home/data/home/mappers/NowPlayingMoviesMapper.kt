package com.project.feature.home.data.home.mappers

import com.project.core.data.networking.UrlConstants
import com.project.feature.home.data.home.models.NowPlayingMovieDatesDto
import com.project.feature.home.data.home.models.NowPlayingMovieResultDto
import com.project.feature.home.data.home.models.NowPlayingMoviesDto
import com.project.feature.home.domain.home.models.NowPlayingMovieDates
import com.project.feature.home.domain.home.models.NowPlayingMovieResult
import com.project.feature.home.domain.home.models.NowPlayingMovies

fun NowPlayingMoviesDto.toDomain(): NowPlayingMovies {
    return NowPlayingMovies(
        dates = dates?.toDomain(),
        page = page,
        results = results?.map { it.toDomain() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun NowPlayingMovieDatesDto.toDomain(): NowPlayingMovieDates {
    return NowPlayingMovieDates(
        maximum = maximum,
        minimum = minimum
    )
}

private fun NowPlayingMovieResultDto.toDomain(): NowPlayingMovieResult {
    return NowPlayingMovieResult(
        adult = adult,
        backdropPath = "${UrlConstants.BACKDROP_IMAGE_BASE_URL}$backdropPath",
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = "${UrlConstants.POSTER_IMAGE_BASE_URL}$posterPath",
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}