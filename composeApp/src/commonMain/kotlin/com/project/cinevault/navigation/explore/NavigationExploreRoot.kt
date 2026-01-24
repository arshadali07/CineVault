package com.project.cinevault.navigation.explore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.project.cinevault.navigation.NavigationRoute
import com.project.feature.home.presentation.home.MoviesHomeRoot
import com.project.feature.movies.presentation.movie_detail.MovieDetailsScreen
import com.project.feature.movies.presentation.movies.MoviesScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationExploreRoot(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(NavigationRoute.Explore.Movies::class, NavigationRoute.Explore.Movies.serializer())
                    subclass(NavigationRoute.Explore.MovieDetails::class, NavigationRoute.Explore.MovieDetails.serializer())
                }
            }
        },
        NavigationRoute.Explore.Movies
    )
    NavDisplay(
        modifier = modifier.fillMaxSize(),
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<NavigationRoute.Explore.Movies> {
                MoviesScreen(
                    onMovieClick = {
                        backStack.add(NavigationRoute.Explore.MovieDetails(movieId = it.id))
                    }
                )
            }
            entry<NavigationRoute.Explore.MovieDetails> {
                MovieDetailsScreen(movieId = it.movieId)
            }
            entry<NavigationRoute.Home> {
                MoviesHomeRoot()
            }
        }
    )
}