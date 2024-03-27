package com.kishan.myapplication.model

data class Song(
    val id: Int,
    val status: String,
    val sort: Int?,
    val userCreated: String,
    val dateCreated: String,
    val userUpdated: String,
    val dateUpdated: String,
    val name: String,
    val artist: String,
    val accent: String,
    val cover: String,
    val topTrack: Boolean,
    val url: String
) {
    fun getCoverImageUrl(): String {
        return "https://cs.saespace.co/assets/$cover"
    }
}
