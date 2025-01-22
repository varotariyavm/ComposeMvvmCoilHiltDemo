package com.seekho.seekhojikanapi

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.seekho.seekhojikanapi.data.AnimeItem
import com.seekho.seekhojikanapi.viewmodel.viewmodelJikan

@Composable
fun AnimeListScreen(viewModelObject: viewmodelJikan = hiltViewModel(), onAnimeClick: (Int) -> Unit) {
    val animeList by viewModelObject.animeDataList.collectAsState()

    LaunchedEffect(Unit) {
        viewModelObject.getDataItemList()
    }


    LazyColumn {
        items(animeList) { anime ->
            AnimeItem(anime) { onAnimeClick(anime.mal_id) }
        }
    }
}

@Composable
fun AnimeItem(anime: AnimeItem, onClick: () -> Unit) {
    Row(modifier = Modifier.clickable { onClick() }) {
        Image(
            painter = rememberAsyncImagePainter(anime.images.jpg.image_url),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Column {
            Text(text = anime.title)
            Text(text = "Episodes: ${anime.episodes ?: "N/A"}")
            Text(text = "Rating: ${anime.score ?: "N/A"}")
        }
    }
}
