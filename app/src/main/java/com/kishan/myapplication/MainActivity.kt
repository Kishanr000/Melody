package com.kishan.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kishan.myapplication.model.songlist
import com.kishan.myapplication.ui.mediaplayer.SongPlayBack
import com.kishan.myapplication.ui.screen.BottomNavigationBar
import com.kishan.myapplication.ui.screen.HomeScreens

class MainActivity : ComponentActivity() {

    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = ExoPlayer.Builder(this).build()

        setContent {

            val navController = rememberNavController()
            NavHost(navController, startDestination = "homeScreen") {
                composable("homeScreen") {
                    HomeScreens(navController = navController, songsList = songlist, innerContentPadding = PaddingValues(0.dp)) }
                composable("SongPlayBack") {
                    SongPlayBack(playList = songlist, player = player)
                }
            }
        }
    }
}
