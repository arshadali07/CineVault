package com.project.feature.movies.data.movies.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsDto(
    @SerialName("adult")
    val adult: Boolean?,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    @SerialName("budget")
    val budget: Int?,
    @SerialName("genres")
    val genres: List<MovieDetailsGenreDto>?,
    @SerialName("homepage")
    val homepage: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("imdb_id")
    val imdbId: String?,
    @SerialName("original_language")
    val originalLanguage: String?,
    @SerialName("original_title")
    val originalTitle: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("popularity")
    val popularity: Double?,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("production_companies")
    val productionCompanies: List<MovieDetailsProductionCompanyDto>?,
    @SerialName("production_countries")
    val productionCountries: List<MovieDetailsProductionCountryDto>?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("revenue")
    val revenue: Int?,
    @SerialName("runtime")
    val runtime: Int?,
    @SerialName("spoken_languages")
    val spokenLanguages: List<MovieDetailsSpokenLanguageDto>?,
    @SerialName("status")
    val status: String?,
    @SerialName("tagline")
    val tagline: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("video")
    val video: Boolean?,
    @SerialName("vote_average")
    val voteAverage: Double?,
    @SerialName("vote_count")
    val voteCount: Int?
)

@Serializable
data class MovieDetailsGenreDto(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?
)

@Serializable
data class MovieDetailsProductionCompanyDto(
    @SerialName("id")
    val id: Int?,
    @SerialName("logo_path")
    val logoPath: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("origin_country")
    val originCountry: String?
)

@Serializable
data class MovieDetailsProductionCountryDto(
    @SerialName("iso_3166_1")
    val iso31661: String?,
    @SerialName("name")
    val name: String?
)

@Serializable
data class MovieDetailsSpokenLanguageDto(
    @SerialName("english_name")
    val englishName: String?,
    @SerialName("iso_639_1")
    val iso6391: String?,
    @SerialName("name")
    val name: String?
)