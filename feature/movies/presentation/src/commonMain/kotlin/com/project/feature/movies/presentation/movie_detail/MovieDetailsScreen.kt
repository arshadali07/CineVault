package com.project.feature.movies.presentation.movie_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.SubcomposeAsyncImage
import com.project.core.presentation.designsystem.components.loaders.ShimmerFullScreenLoader
import com.project.core.presentation.designsystem.components.paging.ErrorMessageComponent
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailsScreen(
    movieId: Int?,
    viewModel: MovieDetailsViewModel = viewModel { MovieDetailsViewModel(movieId = movieId) }
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MovieDetailsContent(
        modifier = Modifier,
        uiState = uiState,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetailsContent(
    modifier: Modifier = Modifier,
    uiState: MovieDetailsUiState,
    onAction: (MovieDetailsAction) -> Unit
) {
    val details = uiState.movieDetails
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SubcomposeAsyncImage(
            model = details?.backdropPath,
            contentDescription = "Poster Image",
            contentScale = ContentScale.FillBounds,
            loading = { ShimmerFullScreenLoader() },
            error = { ErrorMessageComponent(errorMessage = it.result.throwable.message) },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = details?.originalTitle ?: "",
                    style = CineVaultTheme.typography.bodyThree16Medium,
                    color = CineVaultTheme.colors.textPrimary
                )
            }
            Text(
                text = "Genres: ${details?.genres?.joinToString { it.name ?: "" }}",
                style = CineVaultTheme.typography.bodyThree16Medium,
                color = CineVaultTheme.colors.textPrimary
            )
            Text(
                text = details?.overview ?: "",
                style = CineVaultTheme.typography.bodyTwo14Regular,
                color = CineVaultTheme.colors.textSecondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailsContentPreview() {
    CineVaultTheme {
        MovieDetailsContent(
            uiState = testUiState,
            onAction = {}
        )
    }
}

private val testUiState = MovieDetailsUiState()