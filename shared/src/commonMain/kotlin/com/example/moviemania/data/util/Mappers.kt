package com.example.moviemania.data.util

import com.example.moviemania.data.model.DMovie
import com.example.moviemania.data.model.DMovieListResponse
import com.example.moviemania.domain.model.Movie
import com.example.moviemania.domain.model.MovieListResponse
import com.example.moviemania.util.Constant

internal fun DMovieListResponse.toMovieListResponse() =
    MovieListResponse(movieList = movieList.toMovieList())

internal fun List<DMovie>.toMovieList() =
    this.map {
        Movie(
            id = it.id,
            title = it.title,
            description = it.overview,
            imageUrl = getImageUrl(posterImage = it.posterImage),
            releaseDate = it.releaseDate,
        )
    }

internal fun DMovie.toMovie() =
    Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterImage = posterImage),
        releaseDate = releaseDate,
    )

private fun getImageUrl(posterImage: String) = "${Constant.TMDB_IMAGE_W500}$posterImage"
