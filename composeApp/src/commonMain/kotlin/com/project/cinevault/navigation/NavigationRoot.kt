package com.project.cinevault.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.project.cinevault.navigation.explore.NavigationExploreRoot
import com.project.cinevault.navigation.home.NavigationHomeRoot

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
    navigationState: NavigationState,
    navigator: Navigator
) {
    NavDisplay(
        modifier = modifier.fillMaxSize(),
        onBack = navigator::goBack,
        entries = navigationState.toEntries(
            entryProvider = entryProvider {
                entry<NavigationRoute.Home> {
                    NavigationHomeRoot()
                }
                entry<NavigationRoute.Explore> {
                    NavigationExploreRoot()
                }
            }
        )
    )
}