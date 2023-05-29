package com.example.anime.data.remote

import com.example.anime.data.mapper.toMangaListModel
import com.example.anime.data.mapper.toMangaModel
import com.example.anime.domain.MangaListModel
import com.example.anime.domain.MangaModel
import com.example.anime.domain.MangaRepository

class MangaRepositoryImpl(
    private val api: MangaApi
): MangaRepository {
    override suspend fun getMangaById(id: Int): MangaModel {
        val response = api.getMangaById(id)
        return response.toMangaModel()
    }

    override suspend fun getMangaList(): MangaListModel {
        val response = api.getListOfManga()
        return response.toMangaListModel()
    }
}