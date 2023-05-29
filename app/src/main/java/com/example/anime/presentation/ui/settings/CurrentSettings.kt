package com.example.anime.presentation.ui.settings

import com.example.anime.presentation.theme.MangaCorners
import com.example.anime.presentation.theme.MangaSize
import com.example.anime.presentation.theme.MangaStyle

data class CurrentSettings(
    val isDarkMode: Boolean,
    val textSize: MangaSize,
    val paddingSize: MangaSize,
    val cornerStyle: MangaCorners,
    val style: MangaStyle,
)