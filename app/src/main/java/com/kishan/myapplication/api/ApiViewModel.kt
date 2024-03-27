package com.kishan.myapplication.api
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishan.myapplication.model.Song
import kotlinx.coroutines.launch

class ApiViewModel : ViewModel() {
    private val _songlist = mutableStateOf<List<Song>>(emptyList())
    private val _selectedSong = mutableStateOf<Song?>(null)
    var errorMessage: String by mutableStateOf("")

    val songlist: MutableState<List<Song>> = _songlist
    val selectedSong: MutableState<Song?> = _selectedSong

    fun songLists() {
        viewModelScope.launch {
            try {
                val apiService = ApiService.getInstance()
                _songlist.value = apiService.getSongs()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun onSongSelected(song: Song) {
        _selectedSong.value = song
    }
}
