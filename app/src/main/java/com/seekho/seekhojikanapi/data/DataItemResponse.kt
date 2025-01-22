package com.seekho.seekhojikanapi.data

data class DataItemResponse(
    val data: AnimeItemDetail
)

data class AnimeItemDetail(
    val title: String,
    val synopsis: String?,
    val genres: List<Genre>,
    val episodes: Int?,
    val score: Float?,
    val trailer: Trailer?,
    val images: ImageObject,
    val characters: List<Character>?
)

data class Genre(val name: String)
data class Trailer(val youtube_id: String?)
data class Character(val name: String)