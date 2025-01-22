package com.seekho.seekhojikanapi.data

data class DataListResponse(
    val data: List<AnimeItem>
)

data class AnimeItem(
    val mal_id: Int,
    val title: String,
    val episodes: Int?,
    val score: Float?,
    val images: ImageObject
)

data class ImageObject(
    val jpg: ImageDetails
)

data class ImageDetails(
    val image_url: String
)