package com.example.anime.data.mapper

import com.example.anime.data.response.Data
import com.example.anime.data.response.MangaResponse
import com.example.anime.domain.MangaModel

fun MangaResponse.toMangaModel(): MangaModel = dataMapper(data)

fun dataMapper(data: Data?): MangaModel = MangaModel(
    id = data?.malId,
    name = data?.title,
    icon = data?.images?.jpg?.imageUrl,
    description = data?.synopsis,
    year = data?.published?.prop?.from?.year,
    type = data?.type
)
