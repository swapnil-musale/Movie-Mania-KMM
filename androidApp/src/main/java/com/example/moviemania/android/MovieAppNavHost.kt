package com.example.moviemania.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviemania.android.common.MovieDetailsScreen
import com.example.moviemania.android.common.MovieListScreen
import com.example.moviemania.android.common.MovieTopAppBar
import com.example.moviemania.android.common.appDestinations
import com.example.moviemania.android.feature.movieDetails.MovieDetailsScreen
import com.example.moviemania.android.feature.movieDetails.MovieDetailsViewModel
import com.example.moviemania.android.feature.movieList.MovieListScreen
import com.example.moviemania.android.feature.movieList.MovieListViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieAppNavHost() {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()

    val isDarkTheme = isSystemInDarkTheme()
    val statusBarColor = if (isDarkTheme) MaterialTheme.colors.primaryVariant else Color.Transparent

    SideEffect {
        systemUiController.setStatusBarColor(color = statusBarColor, darkIcons = isDarkTheme)
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = appDestinations.find {
        backStackEntry?.destination?.route == it.route ||
            backStackEntry?.destination?.route == it.routeWithArgs
    } ?: MovieListScreen

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieTopAppBar(
                canNavigateUp = navController.previousBackStackEntry != null,
                currentDestination = currentScreen,
                onNavigateUp = {
                    navController.navigateUp()
                },
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues = innerPadding),
            startDestination = MovieListScreen.routeWithArgs,
        ) {
            composable(route = MovieListScreen.routeWithArgs) {
                val movieListViewModel: MovieListViewModel = koinViewModel()
                val uiState = movieListViewModel.uiState.collectAsState().value

                MovieListScreen(
                    uiState = uiState,
                    callNextPage = { isForceReload ->
                        movieListViewModel.getMovieList(isForceReload = isForceReload)
                    },
                    navigateToMovieDetailsScreen = { movie ->
                        navController.navigate("${MovieDetailsScreen.route}/${movie.id}")
                    },
                )
            }

            composable(route = MovieDetailsScreen.routeWithArgs) { navBackStackEntry ->
                val movieId = navBackStackEntry.arguments?.getString("movieId") ?: "0"
                val movieDetailsViewModel: MovieDetailsViewModel = koinViewModel(
                    parameters = {
                        parametersOf(movieId.toInt())
                    },
                )
                val uiState = movieDetailsViewModel.uiState.collectAsState().value

                MovieDetailsScreen(uiState = uiState)
            }
        }
    }
}
