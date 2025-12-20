package com.project.feature.movies.data.movies

import com.project.core.data.logging.KermitLogger
import com.project.core.data.networking.HttpClientFactory
import com.project.core.data.networking.get
import com.project.core.data.networking.getHttpClientEngine
import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.core.domain.util.map
import com.project.feature.movies.data.movies.mappers.toDomain
import com.project.feature.movies.data.movies.response.MoviesDto
import com.project.feature.movies.domain.movies.MoviesService
import com.project.feature.movies.domain.movies.models.Movies
import io.ktor.client.HttpClient

class KtorMoviesService(
    private val httpClient: HttpClient = HttpClientFactory(
        cineVaultLogger = KermitLogger
    ).create(getHttpClientEngine())
) : MoviesService {

    override suspend fun getMovies(): Result<Movies, DataError.Remote> {
        return httpClient.get<MoviesDto>(
            route = "/discover/movie"
        ).map { it.toDomain() }
    }

    override suspend fun getPaginatedMovies(page: Int): Result<Movies, DataError.Remote> {
        return httpClient.get<MoviesDto>(
            route = "/discover/movie",
            queryParams = mapOf("page" to page)
        ).map { it.toDomain() }
    }
}