package com.project.cinevault.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationRoute : NavKey {

    @Serializable
    data object Explore : NavigationRoute {
        @Serializable
        data object Movies : NavigationRoute
        @Serializable
        data class MovieDetails(val movieId: Int?) : NavigationRoute
    }

    @Serializable
    data object Home : NavigationRoute {
        @Serializable
        data object MoviesHome : NavigationRoute
    }
}