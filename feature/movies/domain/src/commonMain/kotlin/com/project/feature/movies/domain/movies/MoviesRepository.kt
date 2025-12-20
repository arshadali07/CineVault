package com.project.feature.movies.domain.movies

import com.project.core.domain.util.DataError
import com.project.core.domain.util.Result
import com.project.feature.movies.domain.movies.models.Movies

interface MoviesRepository {
    suspend fun getMovies(): Result<Movies, DataError.Remote>
}