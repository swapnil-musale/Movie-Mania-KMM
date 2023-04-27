package com.example.moviemania.data.remote

import Movie_Mania.shared.BuildConfig
import com.example.moviemania.util.Constant
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal abstract class KtorApi {
    val httpClient = HttpClient {
        install(plugin = ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                },
            )
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(Constant.BASE_URL)
            path("3", path)
            parameter(Constant.KEY_HEADER_API_KEY, BuildConfig.API_KEY)
        }
    }
}
