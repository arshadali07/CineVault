package com.project.feature.movies.domain.movies

import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.feature.movies.domain.movies.models.Movies

interface MoviesService {
    suspend fun getMovies(): Result<Movies, DataError.Remote>
    suspend fun getPaginatedMovies(page: Int): Result<Movies, DataError.Remote>
}