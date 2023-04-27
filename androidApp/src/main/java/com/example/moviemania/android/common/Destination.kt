package com.example.moviemania.android.common

interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
}

object MovieListScreen : Destination {
    override val title: String
        get() = "Movie Mania"

    override val route: String
        get() = "movie_list"

    override val routeWithArgs: String
        get() = route
}

object MovieDetailsScreen : Destination {
    override val title: String
        get() = "Movie Details"

    override val route: String
        get() = "movie_details"

    override val routeWithArgs: String
        get() = "$route/{movieId}"
}

val appDestinations = listOf(MovieListScreen, MovieDetailsScreen)
