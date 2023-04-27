package com.example.moviemania.android.feature.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviemania.domain.model.Movie
import com.example.moviemania.domain.useCase.GetMovieListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getMovieListUseCase: GetMovieListUseCase,
) : ViewModel() {

    private var currentPageNo: Int = 1

    private val _uiState = MutableStateFlow(MovieListState())
    val uiState = _uiState.asStateFlow()

    init {
        getMovieList()
    }

    fun getMovieList(isForceReload: Boolean = false) {
        if (uiState.value.isLoading) return
        if (isForceReload) currentPageNo = 1
        if (currentPageNo == 1) _uiState.value = _uiState.value.copy(isRefreshing = true)

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val response = getMovieListUseCase(pageNo = currentPageNo)
                val movieList =
                    if (currentPageNo == 1) response.movieList else _uiState.value.movieList + response.movieList
                currentPageNo++
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isRefreshing = false,
                    movieList = movieList,
                    isLoadingFinished = response.movieList.isEmpty(),
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isRefreshing = false,
                    isLoadingFinished = true,
                    errorMessage = e.localizedMessage.orEmpty(),
                )
            }
        }
    }
}

data class MovieListState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val movieList: List<Movie> = emptyList(),
    val errorMessage: String = "",
    val isLoadingFinished: Boolean = false,
)
