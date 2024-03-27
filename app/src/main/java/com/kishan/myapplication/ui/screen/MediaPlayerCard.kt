package com.kishan.myapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.kishan.myapplication.model.Song
import com.kishan.myapplication.model.songlist
import com.kishan.myapplication.ui.mediaplayer.MediaPlayer

@Composable
fun MediaPlayerCard(navController: NavHostController, modifier: Modifier = Modifier, song: Song,) {
    var songState by remember { mutableStateOf(false) }
    if(songState) {
        MediaPlayer.playStream(song.url, songlist.map { it.url })
    } else {
        MediaPlayer.pauseStream()
    }

    Card(
        colors = CardDefaults.cardColors(Color(0xFF150F07)),
        modifier = modifier.height(50.dp), elevation =  CardDefaults.cardElevation(
        defaultElevation = 0.dp,
    ),) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 18.dp, end = 20.dp)
                .fillMaxWidth()
                .clickable {
                    // Navigate to SongPlayBack screen when card is clicked
                    navController.navigate("SongPlayBack")
                }
        ) {
            AsyncImage(
                model = "https://cms.samespace.com/assets/${song.cover}",
                contentDescription = "Song thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)

            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = song.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
                Text(
                    text = song.artist,
                    fontSize = 14.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Light,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            }
            Box(modifier = Modifier.clip(CircleShape).background(Color.White)){
                Icon(tint = Color.Black,
                    imageVector = if (songState) {
                        Icons.Filled.Pause
                    } else {
                        Icons.Filled.PlayArrow
                    },
                    contentDescription = "Play/Pause",
                    modifier = Modifier
                        .clickable {
                            songState = !songState
                        }
                        .height(44.dp)
                        .width(44.dp))
            }
            }

    }

    DisposableEffect(song.url){
        onDispose {
            songState = false
            MediaPlayer.releasePlayer()
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun MediaPlayerCardPreview() {
//    MediaPlayerCard(
//        song = songlist[0],
//    )
//}