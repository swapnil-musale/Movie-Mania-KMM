package com.example.moviemania.android.feature.movieList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import com.example.moviemania.domain.model.Movie

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieListScreen(
    uiState: MovieListState,
    callNextPage: (isForceReload: Boolean) -> Unit,
    navigateToMovieDetailsScreen: (Movie) -> Unit,
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = uiState.isRefreshing,
        onRefresh = { callNextPage(true) },
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
            .pullRefresh(state = pullRefreshState),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(all = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
            verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        ) {
            itemsIndexed(
                items = uiState.movieList,
                key = { index: Int, item: Movie ->
                    item.id
                },
            ) { index: Int, item: Movie ->
                MovieListItem(
                    movie = item,
                    onMovieClicked = navigateToMovieDetailsScreen,
                )

                if (index >= uiState.movieList.size - 1 && uiState.isLoading.not() && uiState.isLoadingFinished.not()) {
                    LaunchedEffect(key1 = Unit) {
                        callNextPage(false)
                    }
                }
            }

            if (uiState.isLoading && uiState.movieList.isNotEmpty()) {
                item(span = { GridItemSpan(currentLineSpan = 2) }) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(all = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        CircularProgressIndicator(color = Red)
                    }
                }
            }
        }

        PullRefreshIndicator(
            refreshing = uiState.isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(alignment = Alignment.TopCenter),
            contentColor = MaterialTheme.colors.primary,
        )
    }
}
