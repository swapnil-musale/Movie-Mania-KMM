package com.example.moviemania.android.di

import com.example.moviemania.android.feature.movieDetails.MovieDetailsViewModel
import com.example.moviemania.android.feature.movieList.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { params ->
        MovieDetailsViewModel(getMovieDetailsUseCase = get(), movieId = params[0])
    }
}
