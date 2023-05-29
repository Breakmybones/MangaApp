package com.example.anime.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.anime.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.anime.presentation.theme.MangaTheme


@Composable
fun ThirdScreen() {
    ThirdScreenContent()
}

@Composable
fun ThirdScreenContent() {
    Image(
        painter = painterResource(id = R.drawable.android),
        contentDescription = null,
        modifier = Modifier.fillMaxSize().background(MangaTheme.colors.primaryBackground),
    )
}