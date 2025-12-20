package com.project.core.presentation.designsystem.components.loaders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.core.presentation.designsystem.components.custom_modifiers.shimmerEffect
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CircularFullScreenLoader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerFullScreenLoader() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .shimmerEffect()
    )
}

@Preview(showBackground = true)
@Composable
private fun CircularFullScreenLoaderPreview() {
    CineVaultTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(color = Color.Black),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CircularFullScreenLoader()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShimmerFullScreenLoaderPreview() {
    CineVaultTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(color = Color.Black),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ShimmerFullScreenLoader()
        }
    }
}