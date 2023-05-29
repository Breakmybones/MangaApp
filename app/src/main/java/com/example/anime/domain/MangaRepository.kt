package com.example.anime.domain

interface MangaRepository {

    suspend fun getMangaById(id: Int): MangaModel

    suspend fun getMangaList(): MangaListModel
}