package com.project.feature.home.data.home

import com.project.core.data.logging.KermitLogger
import com.project.core.data.networking.HttpClientFactory
import com.project.core.data.networking.get
import com.project.core.data.networking.getHttpClientEngine
import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.core.domain.util.map
import com.project.feature.home.data.home.mappers.toDomain
import com.project.feature.home.data.home.models.NowPlayingMoviesDto
import com.project.feature.home.data.home.models.NowPlayingTvSeriesDto
import com.project.feature.home.data.home.models.PopularMoviesDto
import com.project.feature.home.domain.home.HomeService
import com.project.feature.home.domain.home.models.NowPlayingMovies
import com.project.feature.home.domain.home.models.NowPlayingTvSeries
import com.project.feature.home.domain.home.models.PopularMovies
import io.ktor.client.HttpClient

class KtorHomeService(
    private val httpClient: HttpClient = HttpClientFactory(
        cineVaultLogger = KermitLogger
    ).create(getHttpClientEngine())
) : HomeService {

    override suspend fun getPopularMovies(): Result<PopularMovies, DataError.Remote> {
        return httpClient.get<PopularMoviesDto>(
            route = "/movie/popular"
        ).map { it.toDomain() }
    }

    override suspend fun getNowPlayingMovies(): Result<NowPlayingMovies, DataError.Remote> {
        return httpClient.get<NowPlayingMoviesDto>(
            route = "/movie/now_playing"
        ).map { it.toDomain() }
    }

    override suspend fun getNowPlayingTvSeries(): Result<NowPlayingTvSeries, DataError.Remote> {
        return httpClient.get<NowPlayingTvSeriesDto>(
            route = "/tv/on_the_air"
        ).map { it.toDomain() }
    }
}