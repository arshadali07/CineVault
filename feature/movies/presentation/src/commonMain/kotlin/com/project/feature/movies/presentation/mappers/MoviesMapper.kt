package com.project.feature.movies.presentation.mappers

import com.project.feature.movies.domain.movies.models.Movies
import com.project.feature.movies.domain.movies.models.MoviesResult
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

fun MoviesResult.toUi(): MoviesResultUi {
    return MoviesResultUi(
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