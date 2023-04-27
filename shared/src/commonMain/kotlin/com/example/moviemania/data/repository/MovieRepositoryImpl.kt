package com.example.moviemania.data.repository

import com.example.moviemania.data.remote.RemoteDataSource
import com.example.moviemania.data.util.toMovie
import com.example.moviemania.data.util.toMovieListResponse
import com.example.moviemania.domain.model.Movie
import com.example.moviemania.domain.model.MovieListResponse
import com.example.moviemania.domain.repository.MovieRepository

internal class MovieRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    MovieRepository {

    override suspend fun getMovieList(pageNo: Int): MovieListResponse =
        remoteDataSource.getMovieList(pageNo = pageNo).toMovieListResponse()

    override suspend fun getMovieDetails(movieId: Int): Movie =
        remoteDataSource.getMovieDetails(movieId = movieId).toMovie()
}
