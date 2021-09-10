package com.monsterlud.groovestock.database.repository

import com.monsterlud.groovestock.database.dao.AlbumDao
import com.monsterlud.groovestock.database.dao.ArtistDao
import com.monsterlud.groovestock.models.Album
import com.monsterlud.groovestock.models.Artist

class AlbumRepositoryImpl(
    private val albumDao: AlbumDao,
    private val artistDao: ArtistDao
) : AlbumRepository
 {
     override fun getAllAlbums(): List<Album> = albumDao.getAllAlbums()

     override fun addAlbums(albums: List<Album>) = albumDao.addAlbums(albums)

     override fun addAlbum(album: Album) = albumDao.addAlbum(album)

     override fun updateAlbum(album: Album) = albumDao.updateAlbum(album)

     override fun deleteAlbum(album: Album) = albumDao.deleteAlbum(album)

     override fun getAllArtists(): List<Artist> = artistDao.getAllArtists()

     override fun addArtist(artist: Artist) = artistDao.addArtist(artist)

     override fun updateArtist(artist: Artist) = artistDao.updateArtist(artist)

     override fun deleteArtist(artist: Artist) = artistDao.deleteArtist(artist)

 }