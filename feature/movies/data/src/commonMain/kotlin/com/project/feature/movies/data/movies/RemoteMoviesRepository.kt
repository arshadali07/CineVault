package com.project.feature.movies.data.movies

import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.feature.movies.domain.movies.MoviesRepository
import com.project.feature.movies.domain.movies.MoviesService
import com.project.feature.movies.domain.movies.models.Movies

class RemoteMoviesRepository(
    private val moviesService: MoviesService = KtorMoviesService(),
) : MoviesRepository {

    override suspend fun getMovies(): Result<Movies, DataError.Remote> {
        return moviesService.getMovies()
    }
}