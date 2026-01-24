package com.project.cinevault

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.project.cinevault.navigation.NavigationRoot
import com.project.cinevault.navigation.NavigationRoute
import com.project.cinevault.navigation.Navigator
import com.project.cinevault.navigation.bottom_app_bar.CineVaultBottomAppBar
import com.project.cinevault.navigation.bottom_app_bar.TOP_LEVEL_DESTINATIONS
import com.project.cinevault.navigation.rememberNavigationState
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navigationState = rememberNavigationState(
        startRoute = NavigationRoute.Home,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys
    )
    val navigator = remember { Navigator(navigationState) }

    CineVaultTheme {
        Scaffold(
            containerColor = CineVaultTheme.colors.backgroundPrimary,
            contentWindowInsets = WindowInsets(0),
            bottomBar = {
                CineVaultBottomAppBar(
                    selectedKey = navigationState.topLevelRoute,
                    onSelectKey = navigator::navigate
                )
            }
        ) { innerPadding ->
            NavigationRoot(
                modifier = Modifier.padding(innerPadding),
                navigationState = navigationState,
                navigator = navigator
            )
        }
    }
}