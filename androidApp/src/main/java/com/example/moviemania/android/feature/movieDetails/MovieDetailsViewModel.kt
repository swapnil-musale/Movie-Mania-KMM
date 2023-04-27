package com.example.moviemania.android.feature.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviemania.domain.model.Movie
import com.example.moviemania.domain.useCase.GetMovieDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val movieId: Int,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MovieDetailsScreenState> =
        MutableStateFlow(MovieDetailsScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            try {
                val response = getMovieDetailsUseCase(movieId = movieId)
                _uiState.value = _uiState.value.copy(isLoading = false, movieDetails = response)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.localizedMessage.orEmpty(),
                )
            }
        }
    }
}

data class MovieDetailsScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val movieDetails: Movie? = null,
)
