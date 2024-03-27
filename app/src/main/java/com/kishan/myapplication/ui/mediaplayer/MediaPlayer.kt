package com.kishan.myapplication.ui.mediaplayer

import android.media.MediaPlayer

class MediaPlayer {
    companion object {
        private var mediaPlayer: MediaPlayer? = null
        private var currentPosition = 0
        private var songList: List<String>? = null
        private var currentSongIndex = 0

        fun playStream(url: String, songs: List<String>) {
            mediaPlayer?.let {
                if(it.isPlaying) {
                    mediaPlayer?.stop()
                    mediaPlayer?.reset()
                }
            }
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(url)
                prepareAsync()
            }
            mediaPlayer?.setOnPreparedListener { mediaPlayer ->
                mediaPlayer.seekTo(currentPosition)
                mediaPlayer.start()
            }
            songList = songs
            currentSongIndex = songList?.indexOf(url) ?: 0
        }

        fun pauseStream() {
            mediaPlayer?.let {
                currentPosition = it.currentPosition
                it.pause()
            }
        }

        fun stopStream() {
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            currentPosition = 0
        }

        fun releasePlayer() {
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
            currentPosition = 0
        }

        fun playNext() {
            songList?.let { songs ->
                if (currentSongIndex < songs.size - 1) {
                    currentSongIndex++
                    val nextSongUrl = songs[currentSongIndex]
                    playStream(nextSongUrl, songs)
                }
            }
        }

        fun playPrevious() {
            songList?.let { songs ->
                if (currentSongIndex > 0) {
                    currentSongIndex--
                    val previousSongUrl = songs[currentSongIndex]
                    playStream(previousSongUrl, songs)
                }
            }
        }
    }
}
