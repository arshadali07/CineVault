package com.project.feature.home.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.SubcomposeAsyncImage
import com.project.core.presentation.designsystem.components.loaders.ShimmerFullScreenLoader
import com.project.core.presentation.designsystem.components.paging.ErrorMessageComponent
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import com.project.feature.home.presentation.home.model.NowPlayingMoviesUi
import com.project.feature.home.presentation.home.model.NowPlayingTvSeriesUi
import com.project.feature.home.presentation.home.model.PopularMoviesUi
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviesHomeRoot(
    viewModel: MoviesHomeViewModel = viewModel { MoviesHomeViewModel() }
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MoviesHomeScreen(
        modifier = Modifier,
        uiState = uiState,
        onAction = viewModel::onAction
    )
}

@Composable
private fun MoviesHomeScreen(
    modifier: Modifier = Modifier,
    uiState: MoviesHomeUiState,
    onAction: (MoviesHomeAction) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier.fillMaxSize()
    ) {
        uiState.popularMovies?.let { popularMovies ->
            PopularMoviesComponent(
                popularMovies = popularMovies
            )
        }
        uiState.nowPlayingMovies?.let { nowPlayingMovies ->
            NowPlayingMoviesComponent(
                nowPlayingMovies = nowPlayingMovies
            )
        }
        uiState.nowPlayingTvSeries?.let { nowPlayingTvSeries ->
            NowPlayingTvSeriesComponent(
                nowPlayingTvSeries = nowPlayingTvSeries
            )
        }
    }
}

@Composable
private fun PopularMoviesComponent(
    modifier: Modifier = Modifier,
    popularMovies: PopularMoviesUi
) {
    val moviesResult = popularMovies.results
    if (!moviesResult.isNullOrEmpty()) {
        val pagerState = rememberPagerState(pageCount = { moviesResult.size })
        LaunchedEffect(Unit) {
            while (true) {
                delay(3000)
                if (pagerState.currentPage == moviesResult.lastIndex) {
                    pagerState.scrollToPage(page = 0)
                } else {
                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                }
            }
        }
        Box(
            modifier = modifier.fillMaxWidth()
        ) {
            HorizontalPager(
                state = pagerState
            ) { index ->
                moviesResult.getOrNull(index)?.let { movie ->
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SubcomposeAsyncImage(
                            model = movie.backdropPath,
                            contentDescription = "Backdrop Image",
                            contentScale = ContentScale.FillBounds,
                            loading = { ShimmerFullScreenLoader() },
                            error = { ErrorMessageComponent(errorMessage = it.result.throwable.message) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.8f)
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .align(Alignment.BottomCenter)
                        ) {
                            Text(
                                text = movie.title ?: "",
                                style = CineVaultTheme.typography.headlineOne18Medium,
                                color = CineVaultTheme.colors.backgroundPrimary
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(10.dp)
                                            .background(
                                                color = Color.White,
                                                shape = CircleShape
                                            )
                                    )
                                    Text(
                                        text = "Play",
                                        style = CineVaultTheme.typography.captionOne10Regular,
                                        color = CineVaultTheme.colors.backgroundPrimary
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(10.dp)
                                            .background(
                                                color = Color.White,
                                                shape = CircleShape
                                            )
                                    )
                                    Text(
                                        text = "My List",
                                        style = CineVaultTheme.typography.captionOne10Regular,
                                        color = CineVaultTheme.colors.backgroundPrimary
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .statusBarsPadding()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                )
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Composable
private fun NowPlayingMoviesComponent(
    modifier: Modifier = Modifier,
    nowPlayingMovies: NowPlayingMoviesUi
) {
    val moviesList = nowPlayingMovies.results
    if (!moviesList.isNullOrEmpty()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Now Playing Movies",
                    style = CineVaultTheme.typography.headlineOne18Medium,
                    color = CineVaultTheme.colors.textPrimary,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "See all",
                    style = CineVaultTheme.typography.headlineOne18Medium,
                    color = CineVaultTheme.colors.textPrimary
                )
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(items = moviesList) { movie ->
                    SubcomposeAsyncImage(
                        model = movie.posterPath,
                        contentDescription = "Poster Image",
                        contentScale = ContentScale.FillBounds,
                        loading = { ShimmerFullScreenLoader() },
                        error = { ErrorMessageComponent(errorMessage = it.result.throwable.message) },
                        modifier = Modifier
                            .fillParentMaxWidth(0.4f)
                            .aspectRatio(0.7f)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .clickable(onClick = { })
                    )
                }
            }
        }
    }
}

@Composable
private fun NowPlayingTvSeriesComponent(
    modifier: Modifier = Modifier,
    nowPlayingTvSeries: NowPlayingTvSeriesUi
) {
    val tvSeriesList = nowPlayingTvSeries.results
    if (!tvSeriesList.isNullOrEmpty()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Now Playing TV Series",
                    style = CineVaultTheme.typography.headlineOne18Medium,
                    color = CineVaultTheme.colors.textPrimary,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "See all",
                    style = CineVaultTheme.typography.headlineOne18Medium,
                    color = CineVaultTheme.colors.textPrimary
                )
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(items = tvSeriesList) { tvSeries ->
                    SubcomposeAsyncImage(
                        model = tvSeries.posterPath,
                        contentDescription = "Poster Image",
                        contentScale = ContentScale.FillBounds,
                        loading = { ShimmerFullScreenLoader() },
                        error = { ErrorMessageComponent(errorMessage = it.result.throwable.message) },
                        modifier = Modifier
                            .fillParentMaxWidth(0.4f)
                            .aspectRatio(0.7f)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .clickable(onClick = { })
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviesHomeScreenPreview() {
    CineVaultTheme {
        MoviesHomeScreen(
            uiState = testUiState,
            onAction = {}
        )
    }
}

private val testUiState = MoviesHomeUiState()