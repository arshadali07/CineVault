package com.project.feature.home.data.home

import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.feature.home.domain.home.HomeRepository
import com.project.feature.home.domain.home.HomeService
import com.project.feature.home.domain.home.models.NowPlayingMovies
import com.project.feature.home.domain.home.models.NowPlayingTvSeries
import com.project.feature.home.domain.home.models.PopularMovies

class RemoteHomeRepository(
    private val moviesService: HomeService = KtorHomeService(),
) : HomeRepository {

    override suspend fun getPopularMovies(): Result<PopularMovies, DataError.Remote> {
        return moviesService.getPopularMovies()
    }

    override suspend fun getNowPlayingMovies(): Result<NowPlayingMovies, DataError.Remote> {
        return moviesService.getNowPlayingMovies()
    }

    override suspend fun getNowPlayingTvSeries(): Result<NowPlayingTvSeries, DataError.Remote> {
        return moviesService.getNowPlayingTvSeries()
    }
}