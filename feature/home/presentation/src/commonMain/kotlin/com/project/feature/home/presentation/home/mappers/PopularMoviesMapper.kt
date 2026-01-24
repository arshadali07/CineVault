package com.project.feature.home.presentation.home.mappers

import com.project.feature.home.domain.home.models.PopularMovieResult
import com.project.feature.home.domain.home.models.PopularMovies
import com.project.feature.home.presentation.home.model.PopularMovieResultUi
import com.project.feature.home.presentation.home.model.PopularMoviesUi

fun PopularMovies.toUi(): PopularMoviesUi {
    return PopularMoviesUi(
        page = page,
        results = results?.map { it.toUi() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun PopularMovieResult.toUi(): PopularMovieResultUi {
    return PopularMovieResultUi(
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