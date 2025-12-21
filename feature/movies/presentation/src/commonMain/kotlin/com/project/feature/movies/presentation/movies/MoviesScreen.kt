package com.project.feature.movies.presentation.movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.SubcomposeAsyncImage
import com.project.core.presentation.designsystem.components.loaders.CircularFullScreenLoader
import com.project.core.presentation.designsystem.components.loaders.ShimmerFullScreenLoader
import com.project.core.presentation.designsystem.components.paging.ErrorMessageComponent
import com.project.core.presentation.designsystem.components.paging.PaginationLoadErrorComponent
import com.project.core.presentation.designsystem.components.paging.PagingLoaderComponent
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import com.project.feature.movies.presentation.movies.models.MoviesResultUi
import kotlinx.coroutines.flow.emptyFlow
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = viewModel { MoviesViewModel() },
    onMovieClick: (MoviesResultUi) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val pagingData = viewModel.paginateMovies.collectAsLazyPagingItems()
    MoviesContent(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        uiState = uiState,
        pagingData = pagingData,
        onAction = viewModel::onAction,
        onMovieClick = onMovieClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MoviesContent(
    modifier: Modifier = Modifier,
    uiState: MoviesUiState,
    pagingData: LazyPagingItems<MoviesResultUi>,
    onAction: (MoviesAction) -> Unit,
    onMovieClick: (MoviesResultUi) -> Unit
) {
    when (val state = pagingData.loadState.refresh) {
        is LoadState.Error -> ErrorMessageComponent(errorMessage = state.error.message)
        is LoadState.Loading -> CircularFullScreenLoader()
        is LoadState.NotLoading -> {
            val count = pagingData.itemCount
            if (count > 0) {
                MoviesContentList(
                    modifier = modifier,
                    pagingData = pagingData,
                    onMovieClick = onMovieClick
                )
            } else {
                ErrorMessageComponent(
                    errorMessage = "Unable to fetch movies please try again later"
                )
            }
        }
    }
}

@Composable
private fun MoviesContentList(
    modifier: Modifier = Modifier,
    pagingData: LazyPagingItems<MoviesResultUi>,
    onMovieClick: (MoviesResultUi) -> Unit
) {
    val count = pagingData.itemCount
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Adaptive(minSize = 120.dp),
        verticalItemSpacing = 16.dp,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(count = count) { index ->
            pagingData[index]?.let { movie ->
                SubcomposeAsyncImage(
                    model = movie.posterPath,
                    contentDescription = "Poster Image",
                    contentScale = ContentScale.FillBounds,
                    loading = { ShimmerFullScreenLoader() },
                    error = { ErrorMessageComponent(errorMessage = it.result.throwable.message) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.7f)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .clickable(onClick = { onMovieClick(movie) })
                )
            }
        }
        item(span = StaggeredGridItemSpan.FullLine) {
            when (val state = pagingData.loadState.append) {
                is LoadState.NotLoading -> {}
                is LoadState.Loading -> PagingLoaderComponent()
                is LoadState.Error -> {
                    PaginationLoadErrorComponent(
                        errorMessage = state.error.message,
                        onRetry = { pagingData.retry() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviesContentPreview() {
    CineVaultTheme {
        MoviesContent(
            uiState = testUiState,
            pagingData = emptyFlow<PagingData<MoviesResultUi>>().collectAsLazyPagingItems(),
            onAction = {},
            onMovieClick = {}
        )
    }
}

private val testUiState = MoviesUiState()