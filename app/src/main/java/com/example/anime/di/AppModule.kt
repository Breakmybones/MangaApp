package com.example.anime.di

import com.example.anime.data.utils.AndroidResourceProvider
import com.example.anime.data.utils.ResourceProvider
import com.example.anime.presentation.presenter.DetailViewModel
import com.example.anime.presentation.presenter.HomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val appModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        DetailViewModel(get())
    }
    factory<ResourceProvider> {
        AndroidResourceProvider(get())
    }
}