package com.example.anime.domain

class GetMangaListUseCase(
    private val mangaRepository: MangaRepository
) {
    suspend operator fun invoke(): MangaListModel {
        return mangaRepository.getMangaList()
    }
}
