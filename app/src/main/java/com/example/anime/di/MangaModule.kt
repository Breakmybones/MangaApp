package com.example.anime.di

import com.example.anime.data.remote.MangaApi
import com.example.anime.data.remote.MangaRepositoryImpl
import com.example.anime.domain.GetMangaListUseCase
import com.example.anime.domain.GetMangaUseCase
import com.example.anime.domain.MangaRepository
import org.koin.dsl.module

val mangaModule = module {
    single {
        provideMangaRepository(
            mangaApi = get()
        )
    }
    single {
        provideGetMangaUseCase(
            mangaRepository = get()
        )
    }
    single {
        provideGetMangaListUseCase(
            mangaRepository = get()
        )
    }
}

private fun provideMangaRepository(
    mangaApi: MangaApi
): MangaRepository = MangaRepositoryImpl(mangaApi)

private fun provideGetMangaUseCase(
    mangaRepository: MangaRepository
): GetMangaUseCase = GetMangaUseCase(mangaRepository)

private fun provideGetMangaListUseCase(
    mangaRepository: MangaRepository
): GetMangaListUseCase = GetMangaListUseCase(mangaRepository)