package com.project.cinevault.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationRoute : NavKey {

    @Serializable
    data object Movies : NavigationRoute, NavKey
}