package com.seekho.seekhojikanapi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.seekho.seekhojikanapi.customview.ExoVideoPlayerView
import com.seekho.seekhojikanapi.viewmodel.viewmodelJikan

@Composable
fun AnimeDetailScreen(viewModelObject: viewmodelJikan = hiltViewModel(), animeId: Int) {
    val animeDetail by viewModelObject.animeDataDetail.collectAsState()

    LaunchedEffect(Unit) {
        viewModelObject.getDataItemDetail(animeId)
    }

    animeDetail?.let { detail ->
        Column {
            if (!detail.trailer?.youtube_id.isNullOrEmpty()) {
                ExoVideoPlayerView(youtubeId = detail.trailer!!.youtube_id!!)
            } else {
                Image(
                    painter = rememberAsyncImagePainter(detail.images.jpg.image_url),
                    contentDescription = null
                )
            }
            Text(text = detail.title)
            Text(text = detail.synopsis ?: "No synopsis available")
            Text(text = "Episodes: ${detail.episodes ?: "N/A"}")
            Text(text = "Rating: ${detail.score ?: "N/A"}")
            Text(text = "Genres: ${detail.genres.joinToString { it.name }}")
        }
    }
}