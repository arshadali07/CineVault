package com.project.feature.movies.presentation.mappers

import com.project.feature.movies.domain.movies.models.MovieDetails
import com.project.feature.movies.domain.movies.models.MovieDetailsGenre
import com.project.feature.movies.domain.movies.models.MovieDetailsProductionCompany
import com.project.feature.movies.domain.movies.models.MovieDetailsProductionCountry
import com.project.feature.movies.domain.movies.models.MovieDetailsSpokenLanguage
import com.project.feature.movies.presentation.movie_detail.models.MovieDetailsGenreUi
import com.project.feature.movies.presentation.movie_detail.models.MovieDetailsProductionCompanyUi
import com.project.feature.movies.presentation.movie_detail.models.MovieDetailsProductionCountryUi
import com.project.feature.movies.presentation.movie_detail.models.MovieDetailsSpokenLanguageUi
import com.project.feature.movies.presentation.movie_detail.models.MovieDetailsUi

fun MovieDetails.toUi(): MovieDetailsUi {
    return MovieDetailsUi(
        adult = adult,
        backdropPath = backdropPath,
        budget = budget,
        genres = genres?.map { it.toUi() },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies?.map { it.toUi() },
        productionCountries = productionCountries?.map { it.toUi() },
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages?.map { it.toUi() },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

private fun MovieDetailsGenre.toUi(): MovieDetailsGenreUi {
    return MovieDetailsGenreUi(
        id = id,
        name = name
    )
}

private fun MovieDetailsProductionCompany.toUi(): MovieDetailsProductionCompanyUi {
    return MovieDetailsProductionCompanyUi(
        id = id,
        logoPath = logoPath,
        name = name,
        originCountry = originCountry
    )
}

private fun MovieDetailsProductionCountry.toUi(): MovieDetailsProductionCountryUi {
    return MovieDetailsProductionCountryUi(
        iso31661 = iso31661,
        name = name
    )
}

private fun MovieDetailsSpokenLanguage.toUi(): MovieDetailsSpokenLanguageUi {
    return MovieDetailsSpokenLanguageUi(
        englishName = englishName,
        iso6391 = iso6391,
        name = name
    )
}