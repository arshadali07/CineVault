package com.project.feature.movies.presentation.movie_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.core.domain.util.onFailure
import com.project.core.domain.util.onSuccess
import com.project.feature.movies.data.movies.RemoteMoviesRepository
import com.project.feature.movies.domain.movies.MoviesRepository
import com.project.feature.movies.presentation.mappers.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val moviesRepository: MoviesRepository = RemoteMoviesRepository(),
    private val movieId: Int?
) : ViewModel() {

    private val _uiEventChannel = Channel<MovieDetailsEvent>()
    val uiEvent = _uiEventChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(MovieDetailsUiState())
    val uiState = _uiState
        .onStart { getMovieDetails() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MovieDetailsUiState()
        )

    fun onAction(action: MovieDetailsAction) {
        when (action) {
            is MovieDetailsAction.OnBackClickAction -> {}
        }
    }

    private fun getMovieDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isApiLoading = true) }
            val movieId = movieId ?: -1
            moviesRepository.getMovieDetails(movieId)
                .onSuccess { response ->
                    _uiState.update { it.copy(isApiLoading = false, movieDetails = response.toUi()) }
                }
                .onFailure {
                    _uiState.update { it.copy(isApiLoading = false) }
                }
        }
    }
}