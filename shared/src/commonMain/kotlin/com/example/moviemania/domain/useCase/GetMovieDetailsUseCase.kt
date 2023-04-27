package com.example.moviemania.domain.useCase

import com.example.moviemania.domain.model.Movie
import com.example.moviemania.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMovieDetailsUseCase : KoinComponent {

    private val movieRepository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(movieId: Int): Movie =
        movieRepository.getMovieDetails(movieId = movieId)
}
