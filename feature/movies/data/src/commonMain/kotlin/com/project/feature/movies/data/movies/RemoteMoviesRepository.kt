package com.project.feature.movies.data.movies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.feature.movies.domain.movies.MoviesRepository
import com.project.feature.movies.domain.movies.MoviesService
import com.project.feature.movies.domain.movies.models.Movies
import com.project.feature.movies.domain.movies.models.MoviesResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class RemoteMoviesRepository(
    private val moviesService: MoviesService = KtorMoviesService(),
) : MoviesRepository {

    override suspend fun getMovies(): Result<Movies, DataError.Remote> {
        return moviesService.getMovies()
    }

    override fun getPaginatedMovies(): Flow<PagingData<MoviesResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 1
            ),
            initialKey = 1,
            pagingSourceFactory = { MoviesPagingSource(moviesService) }
        ).flow.flowOn(Dispatchers.IO)
    }
}