package com.example.moviemania.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DMovieListResponse(
    @SerialName("results")
    val movieList: List<DMovie>,
)

@Serializable
internal data class DMovie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterImage: String,
    @SerialName("release_date")
    val releaseDate: String,
)
