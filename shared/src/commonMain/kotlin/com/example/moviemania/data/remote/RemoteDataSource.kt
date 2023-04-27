package com.example.moviemania.data.remote

import com.example.moviemania.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val movieService: MovieService,
    private val dispatcher: Dispatcher,
) {
    suspend fun getMovieList(pageNo: Int) = withContext(context = dispatcher.io) {
        movieService.getMovieList(pageNo = pageNo)
    }

    suspend fun getMovieDetails(movieId: Int) = withContext(context = dispatcher.io) {
        movieService.getMovieDetails(movieId = movieId)
    }
}
