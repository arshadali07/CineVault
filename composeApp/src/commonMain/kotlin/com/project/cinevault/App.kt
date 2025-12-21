package com.project.cinevault

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.cinevault.navigation.NavigationRoot
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    CineVaultTheme {
        Scaffold(
            containerColor = CineVaultTheme.colors.backgroundPrimary,
            contentWindowInsets = WindowInsets(0)
        ) { innerPadding ->
            NavigationRoot(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}