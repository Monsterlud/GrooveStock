package com.monsterlud.groovestock.ui.main.viewmodels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.monsterlud.groovestock.App
import com.monsterlud.groovestock.hideSoftKeyBoard
import com.monsterlud.groovestock.models.Album
import com.monsterlud.groovestock.models.Media
import com.monsterlud.groovestock.models.getAlbum
import javax.inject.Inject
import kotlin.properties.Delegates


private const val TAG = "AlbumDetailViewModel"

class AlbumDetailViewModel(
        private val state: SavedStateHandle?
    ): ViewModel() {

    init {
        Log.i(TAG, ": AlbumDetailViewModel Created!")
    }
        var albumId = state?.get<Int>("album_id")
        var album = albumId?.let { App.repository.getAllAlbums().getAlbum(it) }
        var albums = App.repository.getAllAlbums()
        val mediaTypes = Media.values()

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "onCleared: AlbumDetailViewModel Destroyed!")
    }

    fun getMediaEnumValueFromString(name: String) : Media {
        var media = Media.VINYL
        when (name) {
            "VINYL" -> Media.VINYL
            "CD" -> Media.CD
            "MP3" -> Media.MP3
            "CASSETTE" -> Media.CASSETTE
        }
        return media
    }

        fun getMediaEnumValueFromOrdinal(ordinal: Int) : Media {
        var media = Media.VINYL
        if (ordinal == 0) media = Media.VINYL
        else if (ordinal == 1) media = Media.CD
        else if (ordinal == 2) media = Media.MP3
        else media = Media.CASSETTE

        return media
    }

    fun deleteAlbum() {
        album?.let { App.repository.deleteAlbum(it) }
    }

    fun updateAlbum(album: Album) {
        App.repository.updateAlbum(album)
    }

    fun addAlbum(album: Album) {
        App.repository.addAlbum(album)
    }
}