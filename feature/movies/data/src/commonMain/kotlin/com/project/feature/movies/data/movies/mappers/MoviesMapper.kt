package com.project.feature.movies.data.movies.mappers

import com.project.core.data.networking.UrlConstants
import com.project.feature.movies.data.movies.response.MoviesDto
import com.project.feature.movies.data.movies.response.MoviesResultDto
import com.project.feature.movies.domain.movies.models.Movies
import com.project.feature.movies.domain.movies.models.MoviesResult

fun MoviesDto.toDomain(): Movies {
    return Movies(
        page = page,
        results = results?.map { it.toDomain() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun MoviesResultDto.toDomain(): MoviesResult {
    return MoviesResult(
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