package com.monsterlud.groovestock.database.dao

import androidx.room.*
import com.monsterlud.groovestock.models.Album

@Dao
interface AlbumDao {

    @Query("SELECT * FROM album_data_table")
    fun getAllAlbums(): List<Album>

    @Insert
    fun addAlbums(albums: List<Album>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAlbum(album: Album)

    @Update
    fun updateAlbum(album: Album)

    @Delete
    fun deleteAlbum(album: Album)

//    @Query("DELETE FROM album_data_table")
//    fun deleteAllAlbums()
}