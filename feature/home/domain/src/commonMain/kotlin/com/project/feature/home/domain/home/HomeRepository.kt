package com.project.feature.home.domain.home

import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.feature.home.domain.home.models.NowPlayingMovies
import com.project.feature.home.domain.home.models.NowPlayingTvSeries
import com.project.feature.home.domain.home.models.PopularMovies

interface HomeRepository {
    suspend fun getPopularMovies(): Result<PopularMovies, DataError.Remote>
    suspend fun getNowPlayingMovies(): Result<NowPlayingMovies, DataError.Remote>
    suspend fun getNowPlayingTvSeries(): Result<NowPlayingTvSeries, DataError.Remote>
}