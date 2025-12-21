package com.project.cinevault.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.project.feature.movies.presentation.movie_detail.MovieDetailsScreen
import com.project.feature.movies.presentation.movies.MoviesScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(NavigationRoute.Movies::class, NavigationRoute.Movies.serializer())
                    subclass(NavigationRoute.MovieDetails::class, NavigationRoute.MovieDetails.serializer())
                }
            }
        },
        NavigationRoute.Movies
    )
    NavDisplay(
        modifier = modifier.fillMaxSize(),
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                is NavigationRoute.Movies -> {
                    NavEntry(key) {
                        MoviesScreen(
                            onMovieClick = {
                                backStack.add(NavigationRoute.MovieDetails(movieId = it.id))
                            }
                        )
                    }
                }
                is NavigationRoute.MovieDetails -> {
                    NavEntry(key) {
                        MovieDetailsScreen(movieId = key.movieId)
                    }
                }
                else -> error("Unknown NavKey: $key")
            }
        }
    )
}