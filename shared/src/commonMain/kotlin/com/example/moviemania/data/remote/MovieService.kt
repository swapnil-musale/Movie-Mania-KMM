package com.example.moviemania.data.remote

import com.example.moviemania.data.model.DMovie
import com.example.moviemania.data.model.DMovieListResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorApi() {

    suspend fun getMovieList(pageNo: Int = 1): DMovieListResponse =
        httpClient.get {
            pathUrl("movie/popular")
            parameter("page", pageNo)
        }.body()

    suspend fun getMovieDetails(movieId: Int): DMovie =
        httpClient.get {
            pathUrl("movie/$movieId")
        }.body()
}
