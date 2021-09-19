package com.monsterlud.groovestock.ui.main.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.monsterlud.groovestock.App

private const val TAG = "AlbumListViewModel"

class AlbumListViewModel : ViewModel() {

    init {
        Log.i(TAG, ": AlbumListViewModel Created!")
    }

    var albums = App.repository.getAllAlbums()

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "onCleared: AlbumListViewModel Destroyed!")
    }
}