package com.monsterlud.groovestock.database.repository

import com.monsterlud.groovestock.models.Album
import com.monsterlud.groovestock.models.Artist

interface AlbumRepository {

    fun getAllAlbums(): List<Album>

    fun addAlbums(albums: List<Album>)

    fun addAlbum(album: Album)

    fun updateAlbum(album: Album)

    fun deleteAlbum(album: Album)

//    fun deleteAllAlbums()

    fun getAllArtists(): List<Artist>

    fun addArtist(artist: Artist)

    fun updateArtist(artist: Artist)

    fun deleteArtist(artist: Artist)

}