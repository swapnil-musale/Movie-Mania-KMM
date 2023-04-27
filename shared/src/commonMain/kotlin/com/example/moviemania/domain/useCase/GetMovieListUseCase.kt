package com.example.moviemania.domain.useCase

import com.example.moviemania.domain.model.MovieListResponse
import com.example.moviemania.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMovieListUseCase : KoinComponent {
    private val movieRepository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(pageNo: Int): MovieListResponse =
        movieRepository.getMovieList(pageNo = pageNo)
}
