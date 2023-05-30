package com.example.anime.data.mapper

import com.example.anime.data.response.MangaListResponse
import com.example.anime.domain.MangaListModel

fun MangaListResponse.toMangaListModel() = MangaListModel(
    mangaList = data?.map { dataMapper(it) }
)
