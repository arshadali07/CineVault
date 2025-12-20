package com.project.feature.movies.data.movies

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.project.core.domain.util.onFailure
import com.project.core.domain.util.onSuccess
import com.project.feature.movies.domain.movies.MoviesService
import com.project.feature.movies.domain.movies.models.MoviesResult
import kotlinx.io.IOException

class MoviesPagingSource(
    private val moviesService: MoviesService
) : PagingSource<Int, MoviesResult>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesResult> {
        val page = params.key ?: 1
        var loadResult: LoadResult<Int, MoviesResult> = LoadResult.Page(
            data = emptyList(),
            prevKey = null,
            nextKey = null
        )
        try {
            val response = moviesService.getPaginatedMovies(page = page)
            response
                .onSuccess { result ->
                    val movies = result.results.orEmpty()
                    loadResult = LoadResult.Page(
                        data = movies,
                        prevKey = if (page == 1) null else page - 1,
                        nextKey = if (movies.isEmpty()) null else page + 1
                    )
                }
                .onFailure { result ->
                    loadResult = LoadResult.Error(IOException(result.name))
                }
        } catch (e: Exception) {
            loadResult = LoadResult.Error(e)
        }
        return loadResult
    }

    override fun getRefreshKey(state: PagingState<Int, MoviesResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}