package com.project.feature.movies.domain.movies

import androidx.paging.PagingData
import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.feature.movies.domain.movies.models.Movies
import com.project.feature.movies.domain.movies.models.MoviesResult
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getMovies(): Result<Movies, DataError.Remote>
    fun getPaginatedMovies(): Flow<PagingData<MoviesResult>>
}