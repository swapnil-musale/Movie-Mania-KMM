package com.example.moviemania.domain.model

data class MovieListResponse(val movieList: List<Movie>)

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val releaseDate: String,
)
