package com.example.moviemania.android.feature.movieDetails

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviemania.android.MyApplicationTheme
import com.example.moviemania.android.R
import com.example.moviemania.domain.model.Movie

@Composable
fun MovieDetailsScreen(uiState: MovieDetailsScreenState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {
        uiState.movieDetails?.let { safeMovieDetails ->
            val scrollState = rememberScrollState()

            Column(modifier = Modifier.fillMaxWidth()) {
                AsyncImage(
                    model = safeMovieDetails.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 300.dp),
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(state = scrollState)
                        .weight(weight = 1f)
                        .padding(all = 16.dp),
                ) {
                    Text(
                        text = safeMovieDetails.title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onBackground,
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Red),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_play),
                            contentDescription = null,
                            tint = Color.White,
                        )
                        Text(
                            text = "Start Watching Now",
                            color = Color.White,
                            modifier = Modifier.padding(start = 12.dp),
                        )
                    }

                    Text(
                        text = "Released in ${safeMovieDetails.releaseDate}",
                        style = MaterialTheme.typography.overline,
                        modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
                        color = MaterialTheme.colors.onBackground,

                    )

                    Text(
                        text = safeMovieDetails.description,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onBackground,
                    )
                }
            }
        }

        if (uiState.isLoading) {
            CircularProgressIndicator(color = Red)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun MovieDetailsScreenPreview() {
    MyApplicationTheme {
        MovieDetailsScreen(
            uiState = MovieDetailsScreenState(
                isLoading = false,
                movieDetails = Movie(
                    id = 3359,
                    title = "vis",
                    description = "habitasse",
                    imageUrl = "http://www.bing.com/search?q=honestatis",
                    releaseDate = "iriure",
                ),
            ),
        )
    }
}
