package com.monsterlud.groovestock.database.dao

import androidx.room.*
import com.monsterlud.groovestock.models.Artist

@Dao
interface ArtistDao {

    @Query("SELECT * FROM artist_data_table")
    fun getAllArtists(): List<Artist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArtist(artist: Artist)

    @Update
    fun updateArtist(artist: Artist)

    @Delete
    fun deleteArtist(artist: Artist)
}