package com.example.moviemania.android.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviemania.android.MyApplicationTheme

@Composable
fun MovieTopAppBar(
    modifier: Modifier = Modifier,
    canNavigateUp: Boolean,
    currentDestination: Destination,
    onNavigateUp: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height = 56.dp)
            .background(color = MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (canNavigateUp) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = onNavigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primaryVariant,
                        )
                    }
                }
            }
            Text(
                text = currentDestination.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(all = 12.dp),
                color = MaterialTheme.colors.primaryVariant,
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun MovieTopAppBarPreview() {
    MyApplicationTheme {
        MovieTopAppBar(
            canNavigateUp = true,
            currentDestination = MovieDetailsScreen,
            onNavigateUp = {},
        )
    }
}
