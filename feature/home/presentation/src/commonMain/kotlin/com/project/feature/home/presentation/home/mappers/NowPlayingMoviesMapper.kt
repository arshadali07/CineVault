package com.project.feature.home.presentation.home.mappers

import com.project.feature.home.domain.home.models.NowPlayingMovieDates
import com.project.feature.home.domain.home.models.NowPlayingMovieResult
import com.project.feature.home.domain.home.models.NowPlayingMovies
import com.project.feature.home.presentation.home.model.NowPlayingMovieDatesUi
import com.project.feature.home.presentation.home.model.NowPlayingMovieResultUi
import com.project.feature.home.presentation.home.model.NowPlayingMoviesUi

fun NowPlayingMovies.toUi(): NowPlayingMoviesUi {
    return NowPlayingMoviesUi(
        dates = dates?.toUi(),
        page = page,
        results = results?.map { it.toUi() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun NowPlayingMovieDates.toUi(): NowPlayingMovieDatesUi {
    return NowPlayingMovieDatesUi(
        maximum = maximum,
        minimum = minimum
    )
}

private fun NowPlayingMovieResult.toUi(): NowPlayingMovieResultUi {
    return NowPlayingMovieResultUi(
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}