package com.project.feature.movies.presentation.mappers

import com.project.feature.movies.domain.movies.models.Movies
import com.project.feature.movies.domain.movies.models.MoviesResult
import com.project.feature.movies.presentation.movies.models.Constants
import com.project.feature.movies.presentation.movies.models.MoviesResultUi
import com.project.feature.movies.presentation.movies.models.MoviesUi

fun Movies.toUi(): MoviesUi {
    return MoviesUi(
        page = page,
        results = results?.map { it.toUi() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun MoviesResult.toUi(): MoviesResultUi {
    return MoviesResultUi(
        adult = adult,
        backdropPath = "${Constants.BACKDROP_IMAGE_BASE_URL}$backdropPath",
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = "${Constants.BACKDROP_IMAGE_BASE_URL}$posterPath",
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}