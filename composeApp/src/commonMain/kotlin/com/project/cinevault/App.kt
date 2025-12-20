package com.project.cinevault

import androidx.compose.runtime.Composable
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import com.project.feature.movies.presentation.movies.MoviesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    CineVaultTheme {
        MoviesScreen()
    }
}