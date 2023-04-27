package com.example.moviemania.android.feature.movieList

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviemania.android.MyApplicationTheme
import com.example.moviemania.android.R
import com.example.moviemania.domain.model.Movie

@Composable
fun MovieListItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClicked: (Movie) -> Unit,
) {
    Card(
        modifier = modifier
            .height(height = 250.dp)
            .clickable {
                onMovieClicked(movie)
            },
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(size = 8.dp),
    ) {
        Column {
            Box(
                modifier = Modifier.weight(weight = 1f),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    model = movie.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp)),
                )

                Box(
                    modifier = Modifier
                        .size(size = 48.dp)
                        .clip(shape = CircleShape)
                        .background(color = Color.Black.copy(alpha = 0.6f))
                        .padding(all = 12.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = null,
                    )
                }
            }

            Column(modifier = Modifier.padding(all = 12.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = movie.description,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = 1,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun MovieListItemPreview() {
    MyApplicationTheme {
        MovieListItem(
            modifier = Modifier,
            movie = Movie(
                id = 7855,
                title = "audire",
                description = "mucius",
                imageUrl = "https://www.google.com/#q=quo",
                releaseDate = "eleifend",
            ),
            onMovieClicked = {},
        )
    }
}
