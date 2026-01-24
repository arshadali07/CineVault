package com.project.feature.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.core.domain.util.onFailure
import com.project.core.domain.util.onSuccess
import com.project.feature.home.data.home.RemoteHomeRepository
import com.project.feature.home.domain.home.HomeRepository
import com.project.feature.home.presentation.home.mappers.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesHomeViewModel(
    private val homeRepository: HomeRepository = RemoteHomeRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(MoviesHomeUiState())
    val uiState = _uiState
        .onStart { getPopularMovies(); getNowPlayingMovies(); getNowPlayingTvSeries() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MoviesHomeUiState()
        )

    fun onAction(action: MoviesHomeAction) {
        when (action) {
            is MoviesHomeAction.OnBackClickAction -> navigateBack()
        }
    }

    private fun navigateBack() {

    }

    private fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isApiLoading = true) }
            homeRepository.getPopularMovies()
                .onSuccess { response ->
                    _uiState.update { it.copy(isApiLoading = false, popularMovies = response.toUi()) }
                }
                .onFailure {
                    _uiState.update { it.copy(isApiLoading = false) }
                }
        }
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isApiLoading = true) }
            homeRepository.getNowPlayingMovies()
                .onSuccess { response ->
                    _uiState.update { it.copy(isApiLoading = false, nowPlayingMovies = response.toUi()) }
                }
                .onFailure {
                    _uiState.update { it.copy(isApiLoading = false) }
                }
        }
    }

    private fun getNowPlayingTvSeries() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isApiLoading = true) }
            homeRepository.getNowPlayingTvSeries()
                .onSuccess { response ->
                    _uiState.update { it.copy(isApiLoading = false, nowPlayingTvSeries = response.toUi()) }
                }
                .onFailure {
                    _uiState.update { it.copy(isApiLoading = false) }
                }
        }
    }
}