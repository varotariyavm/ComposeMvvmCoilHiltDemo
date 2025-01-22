package com.seekho.seekhojikanapi.network

import com.seekho.seekhojikanapi.data.DataItemResponse
import com.seekho.seekhojikanapi.data.DataListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("top/anime")
    suspend fun getAnimeList(): DataListResponse

    @GET("anime/{anime_id}")
    suspend fun getItemDetails(@Path("anime_id") animeId: Int): DataItemResponse
}