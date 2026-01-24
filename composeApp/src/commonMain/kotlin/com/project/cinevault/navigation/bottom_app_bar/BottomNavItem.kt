package com.project.cinevault.navigation.bottom_app_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import com.project.cinevault.navigation.NavigationRoute

data class BottomNavItem(
    val title: String,
    val icon: ImageVector
)


val TOP_LEVEL_DESTINATIONS = mapOf<NavKey, BottomNavItem>(
    NavigationRoute.Home to BottomNavItem(
        icon = Icons.Outlined.Home,
        title = "Home"
    ),
    NavigationRoute.Explore to BottomNavItem(
        icon = Icons.Outlined.Explore,
        title = "Explore"
    )
)