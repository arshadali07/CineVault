package com.project.feature.home.data.home.mappers

import com.project.core.data.networking.UrlConstants
import com.project.feature.home.data.home.models.PopularMovieResultDto
import com.project.feature.home.data.home.models.PopularMoviesDto
import com.project.feature.home.domain.home.models.PopularMovieResult
import com.project.feature.home.domain.home.models.PopularMovies

fun PopularMoviesDto.toDomain(): PopularMovies {
    return PopularMovies(
        page = page,
        results = results?.map { it.toDomain() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

private fun PopularMovieResultDto.toDomain(): PopularMovieResult {
    return PopularMovieResult(
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