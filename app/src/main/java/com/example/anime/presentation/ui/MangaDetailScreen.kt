package com.example.anime.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.anime.domain.MangaModel
import com.example.anime.presentation.presenter.DetailViewModel
import com.example.anime.presentation.presenter.DetailsEvent
import com.example.anime.presentation.presenter.DetailsViewState
import com.example.anime.presentation.theme.MangaTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MangaDetailScreen(
    mangaId: Int,
    viewModel: DetailViewModel = koinViewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    MangaDetailsContent(
        mangaId = mangaId,
        viewState = state.value,
        eventHandler = viewModel::event)
}

@Composable
fun MangaDetailsContent(
    mangaId: Int,
    viewState: DetailsViewState,
    eventHandler: (DetailsEvent) -> Unit,
) {

    if (viewState.manga == null) {
        eventHandler.invoke(DetailsEvent.OnLoadManga(mangaId))
        if (viewState.loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        }
    } else {
        MangaScreen(viewState.manga)
    }
}

@Composable
fun MangaScreen(
    manga: MangaModel
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(MangaTheme.colors.primaryBackground)) {

        item {
            Row (horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                manga.apply {
                    SubcomposeAsyncImage(
                        model = manga.icon,
                        contentDescription = null) {
                        val state = painter.state
                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                            CircularProgressIndicator(
                                modifier = Modifier.padding(
                                    vertical = 48.dp,
                                    horizontal = 36.dp
                                )
                            )
                        } else {
                            SubcomposeAsyncImageContent(modifier = Modifier
                                .width(200.dp)
                                .height(300.dp),
                                alignment = Alignment.Center,)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
        item {
            manga.apply {
                Spacer(modifier = Modifier.height(24.dp))
                manga.name?.let {
                    Text(
                        text = "Название: $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp, 16.dp, 0.dp),
                        color = MangaTheme.colors.primaryText,
                        style = MangaTheme.typography.manga,
                        textAlign = TextAlign.Center
                    )
                }
                manga.type?.let {
                    Text(
                        text = "Категория: $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp, 16.dp, 0.dp),
                        color = MangaTheme.colors.primaryText,
                        style = MangaTheme.typography.manga,
                        textAlign = TextAlign.Center
                    )
                }
                manga.year?.let {
                    Text(
                        text = "Год выпуска: $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp, 16.dp, 0.dp),
                        color = MangaTheme.colors.primaryText,
                        style = MangaTheme.typography.manga,
                        textAlign = TextAlign.Center
                    )
                }
                manga.description?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp, 16.dp, 0.dp),
                        color = MangaTheme.colors.primaryText,
                        style = MangaTheme.typography.manga,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MangaTheme() {
        MangaScreen(manga = MangaModel(1, "anime", "https:\\/\\/cdn.myanimelist.net\\/images\\/manga\\/3\\/258224t.jpg", "hdhjhjsjорвсыиилмшрслосчччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччччjsdj", 2023, "anime"))
    }
}