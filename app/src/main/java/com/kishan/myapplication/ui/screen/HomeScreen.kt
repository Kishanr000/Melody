package com.kishan.myapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.kishan.myapplication.api.ApiViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.kishan.myapplication.R
import com.kishan.myapplication.model.Song
import com.kishan.myapplication.model.songlist

@Composable
fun HomeScreens(navController: NavHostController,songsList: List<Song>,innerContentPadding: PaddingValues) {
    var selectedSong by remember { mutableStateOf<Song?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerContentPadding)
            .background(Color.Black)
    ) {
        SongsList(songsList = songsList, onSongSelected = { song ->
            selectedSong = song

        })
        selectedSong?.let {
            MediaPlayerCard(
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Transparent),
                it
            )
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
////    val apiViewModel = viewModel<ApiViewModel>()
////    HomeScreen(apiViewModel = apiViewModel)
//    HomeScreens(songsList = songlist, innerContentPadding = PaddingValues(0.dp))
//}