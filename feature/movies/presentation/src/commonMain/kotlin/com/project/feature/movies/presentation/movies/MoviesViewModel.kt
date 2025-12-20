package com.project.feature.movies.presentation.movies

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

class MoviesViewModel(
    private val moviesRepository: MoviesRepository = RemoteMoviesRepository()
) : ViewModel() {

    private val _uiEventChannel = Channel<MoviesEvent>()
    val uiEvent = _uiEventChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(MoviesUiState())
    val uiState = _uiState
        .onStart { getMovies() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MoviesUiState()
        )

    fun onAction(action: MoviesAction) {
        when (action) {
            is MoviesAction.OnBackClickAction -> {}
        }
    }

    private fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isApiLoading = true) }
            moviesRepository.getMovies()
                .onSuccess { response ->
                    _uiState.update { it.copy(isApiLoading = false, movies = response.toUi()) }
                }
                .onFailure {
                    _uiState.update { it.copy(isApiLoading = false) }
                }
        }
    }
}