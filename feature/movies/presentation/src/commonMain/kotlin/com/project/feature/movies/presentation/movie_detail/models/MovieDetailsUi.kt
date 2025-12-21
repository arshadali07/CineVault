package com.project.feature.movies.presentation.movie_detail.models

data class MovieDetailsUi(
    val adult: Boolean?,
    val backdropPath: String?,
    val budget: Int?,
    val genres: List<MovieDetailsGenreUi>?,
    val homepage: String?,
    val id: Int?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val productionCompanies: List<MovieDetailsProductionCompanyUi>?,
    val productionCountries: List<MovieDetailsProductionCountryUi>?,
    val releaseDate: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spokenLanguages: List<MovieDetailsSpokenLanguageUi>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
)

data class MovieDetailsGenreUi(
    val id: Int?,
    val name: String?
)

data class MovieDetailsProductionCompanyUi(
    val id: Int?,
    val logoPath: String?,
    val name: String?,
    val originCountry: String?
)

data class MovieDetailsProductionCountryUi(
    val iso31661: String?,
    val name: String?
)

data class MovieDetailsSpokenLanguageUi(
    val englishName: String?,
    val iso6391: String?,
    val name: String?
)