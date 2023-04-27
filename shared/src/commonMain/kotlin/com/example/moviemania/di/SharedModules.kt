package com.example.moviemania.di

import com.example.moviemania.data.remote.MovieService
import com.example.moviemania.data.remote.RemoteDataSource
import com.example.moviemania.data.repository.MovieRepositoryImpl
import com.example.moviemania.domain.repository.MovieRepository
import com.example.moviemania.domain.useCase.GetMovieDetailsUseCase
import com.example.moviemania.domain.useCase.GetMovieListUseCase
import com.example.moviemania.util.provideDispatcher
import org.koin.dsl.module

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(remoteDataSource = get()) }
    factory { GetMovieListUseCase() }
    factory { GetMovieDetailsUseCase() }
}

private val dataModule = module {
    factory { RemoteDataSource(movieService = get(), dispatcher = get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val sharedModuleList = listOf(domainModule, dataModule, utilityModule)

fun getSharedModule() = sharedModuleList
