package com.seekho.seekhojikanapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seekho.seekhojikanapi.data.AnimeItem
import com.seekho.seekhojikanapi.data.AnimeItemDetail
import com.seekho.seekhojikanapi.network.RetrofitApiObject
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class viewmodelJikan @Inject constructor() : ViewModel() {
    private val dataItemList = MutableStateFlow<List<AnimeItem>>(emptyList())
    val animeDataList: StateFlow<List<AnimeItem>> = dataItemList

    private val dataItemDetail = MutableStateFlow<AnimeItemDetail?>(null)
    val animeDataDetail: StateFlow<AnimeItemDetail?> = dataItemDetail

    fun getDataItemList() {
        viewModelScope.launch {
            try {
                val response = RetrofitApiObject.interfaceObject.getAnimeList()
                dataItemList.value = response.data
            } catch (e: Exception) {
            }
        }
    }

    fun getDataItemDetail(animeId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitApiObject.interfaceObject.getItemDetails(animeId)
                dataItemDetail.value = response.data
            } catch (e: Exception) {
            }
        }
    }
}