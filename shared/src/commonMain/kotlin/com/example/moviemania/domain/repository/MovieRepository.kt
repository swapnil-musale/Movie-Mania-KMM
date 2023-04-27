package com.example.moviemania.domain.repository

import com.example.moviemania.domain.model.Movie
import com.example.moviemania.domain.model.MovieListResponse

internal interface MovieRepository {
    suspend fun getMovieList(pageNo: Int): MovieListResponse
    suspend fun getMovieDetails(movieId: Int): Movie
}
