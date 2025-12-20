package com.project.core.presentation.designsystem.components.paging

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.project.core.presentation.designsystem.components.buttons.CircularButton
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PagingLoaderComponent(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaginationLoadErrorComponent(
    modifier: Modifier = Modifier,
    errorMessage: String? = "Unable to fetch movies please try again later",
    onRetry: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
    ) {
        Text(
            text = errorMessage ?: "Unable to fetch movies please try again later",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        CircularButton(
            buttonText = "Retry",
            onClick = onRetry
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorMessageComponent(
    modifier: Modifier = Modifier,
    errorMessage: String? = "Unable to fetch movies please try again later"
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = errorMessage ?: "Unable to fetch movies please try again later",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PagingComponentsPreview() {
    CineVaultTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(color = Color.Black),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            PagingLoaderComponent()
            PaginationLoadErrorComponent()
            ErrorMessageComponent()
        }
    }
}