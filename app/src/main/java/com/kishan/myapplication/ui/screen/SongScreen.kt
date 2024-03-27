package com.kishan.myapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kishan.myapplication.model.Song
import com.kishan.myapplication.model.songlist


@Composable
fun SongScreen(song: Song, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(Color.Black),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
            .background(Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = "https://cms.samespace.com/assets/${song.cover}",
                contentDescription = "Song thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(304.dp)
                    .clip(RectangleShape)
                ,
            )
            Spacer(modifier = Modifier.height(57.dp))
                Text(
                    text = song.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
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
        }
    }


@Preview(showBackground = true)
@Composable
fun Songs() {
    SongScreen(
        songlist[0],
        onClick = {}
    )
}

//@Composable
//fun SongClick(songsList: List<Song>,song: Song, onSongSelected: (song: Song) -> Unit) {
//    var isSongSelected by remember { mutableStateOf(false) }
//
//    var songState by remember { mutableStateOf(false) }
//    if(songState) {
//        MediaPlayer.playStream(song.url, songlist.map { it.url })
//    } else {
//        MediaPlayer.pauseStream()
//    }
//
//    var next by remember { mutableStateOf(false) }
//    if(next) {
//        MediaPlayer.playNext()
//    } else {
//        MediaPlayer.pauseStream()
//    }
//
//    var previous by remember { mutableStateOf(false) }
//    if(previous) {
//        MediaPlayer.playPrevious()
//    } else {
//        MediaPlayer.pauseStream()
//    }
//
//    Column (horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .padding(top = 45.dp)
//            .fillMaxWidth()){
//        LazyRow(
//            modifier = Modifier
//                .height(480.dp)
//                .fillMaxWidth()
//        ) {
//            items(songsList) { song ->
//                SongScreen(song = song, onClick = {
//                    isSongSelected = true
//                    MediaPlayer.playStream(song.url, songlist.map { it.url })
//                    onSongSelected(song)
//                })
//            }
//        }
//
//        Spacer(modifier = Modifier.height(136.dp))
//
//        Row (verticalAlignment = Alignment.CenterVertically) {
//
//            Icon(
//                imageVector = Icons.Filled.SkipPrevious,
//                contentDescription = "Previous Song",
//                tint = Color.LightGray,
//                modifier = Modifier
//                    .clickable {
//                        previous = !previous
//                    }
//                    .height(50.43.dp)
//                    .width(40.27.dp)
//            )
//            Spacer(modifier = Modifier.width(22.78.dp),)
//            Box(
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .background(Color.White)
//            ) {
//                Icon(tint = Color.Black,
//                    imageVector = if (songState) {
//                        Icons.Filled.Pause
//                    } else {
//                        Icons.Filled.PlayArrow
//                    },
//                    contentDescription = "Play/Pause",
//                    modifier = Modifier
//                        .clickable {
//                            songState = !songState
//                        }
//                        .height(64.dp)
//                        .width(64.dp))
//            }
//            Spacer(modifier = Modifier.width(22.78.dp))
//            Icon(
//                imageVector = Icons.Filled.SkipNext,
//                contentDescription = "Next Song",
//                tint = Color.LightGray,
//                modifier = Modifier
//                    .clickable {
//                        next = !next
//                    }
//                    .height(50.43.dp)
//                    .width(40.27.dp)
//            )
//        }
//
//    }
//}
