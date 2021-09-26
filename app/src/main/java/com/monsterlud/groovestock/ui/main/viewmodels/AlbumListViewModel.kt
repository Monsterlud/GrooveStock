package com.monsterlud.groovestock.ui.main.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.monsterlud.groovestock.App

private const val TAG = "AlbumListViewModel"

class AlbumListViewModel : ViewModel() {

    var albums = App.repository.getAllAlbums()

    init {
        Log.i(TAG, ": AlbumListViewModel Created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "onCleared: AlbumListViewModel Destroyed!")
    }
}