package com.project.feature.movies.data.movies.mappers

import com.project.core.data.networking.UrlConstants
import com.project.feature.movies.data.movies.response.MovieDetailsDto
import com.project.feature.movies.data.movies.response.MovieDetailsGenreDto
import com.project.feature.movies.data.movies.response.MovieDetailsProductionCompanyDto
import com.project.feature.movies.data.movies.response.MovieDetailsProductionCountryDto
import com.project.feature.movies.data.movies.response.MovieDetailsSpokenLanguageDto
import com.project.feature.movies.domain.movies.models.MovieDetails
import com.project.feature.movies.domain.movies.models.MovieDetailsGenre
import com.project.feature.movies.domain.movies.models.MovieDetailsProductionCompany
import com.project.feature.movies.domain.movies.models.MovieDetailsProductionCountry
import com.project.feature.movies.domain.movies.models.MovieDetailsSpokenLanguage

fun MovieDetailsDto.toDomain(): MovieDetails {
    return MovieDetails(
        adult = adult,
        backdropPath = "${UrlConstants.BACKDROP_IMAGE_BASE_URL}$backdropPath",
        budget = budget,
        genres = genres?.map { it.toDomain() },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = "${UrlConstants.POSTER_IMAGE_BASE_URL}$posterPath",
        productionCompanies = productionCompanies?.map { it.toDomain() },
        productionCountries = productionCountries?.map { it.toDomain() },
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages?.map { it.toDomain() },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

private fun MovieDetailsGenreDto.toDomain(): MovieDetailsGenre {
    return MovieDetailsGenre(
        id = id,
        name = name
    )
}

private fun MovieDetailsProductionCompanyDto.toDomain(): MovieDetailsProductionCompany {
    return MovieDetailsProductionCompany(
        id = id,
        logoPath = logoPath,
        name = name,
        originCountry = originCountry
    )
}

private fun MovieDetailsProductionCountryDto.toDomain(): MovieDetailsProductionCountry {
    return MovieDetailsProductionCountry(
        iso31661 = iso31661,
        name = name
    )
}

private fun MovieDetailsSpokenLanguageDto.toDomain(): MovieDetailsSpokenLanguage {
    return MovieDetailsSpokenLanguage(
        englishName = englishName,
        iso6391 = iso6391,
        name = name
    )
}