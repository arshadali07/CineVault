package com.project.feature.movies.domain.movies.models

data class MovieDetails(
    val adult: Boolean?,
    val backdropPath: String?,
    val budget: Int?,
    val genres: List<MovieDetailsGenre>?,
    val homepage: String?,
    val id: Int?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val productionCompanies: List<MovieDetailsProductionCompany>?,
    val productionCountries: List<MovieDetailsProductionCountry>?,
    val releaseDate: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spokenLanguages: List<MovieDetailsSpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
)

data class MovieDetailsGenre(
    val id: Int?,
    val name: String?
)

data class MovieDetailsProductionCompany(
    val id: Int?,
    val logoPath: String?,
    val name: String?,
    val originCountry: String?
)

data class MovieDetailsProductionCountry(
    val iso31661: String?,
    val name: String?
)

data class MovieDetailsSpokenLanguage(
    val englishName: String?,
    val iso6391: String?,
    val name: String?
)