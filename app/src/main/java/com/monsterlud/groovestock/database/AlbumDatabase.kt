package com.monsterlud.groovestock.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.monsterlud.groovestock.database.dao.AlbumDao
import com.monsterlud.groovestock.database.dao.ArtistDao
import com.monsterlud.groovestock.models.Album
import com.monsterlud.groovestock.models.Artist

private const val DATABASE_VERSION = 1
private const val DATABASE_NAME = "GSDatabase"
private const val TAG = "AlbumDatabase"

@Database(
    entities = [Album::class, Artist::class],
    version = DATABASE_VERSION
)
abstract class AlbumDatabase : RoomDatabase() {

    companion object {
        fun buildDatabase(context: Context) : AlbumDatabase {
            return Room.databaseBuilder(
                context,
                AlbumDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .build()
        }
    }

    abstract fun albumDao(): AlbumDao
    abstract fun artistDao(): ArtistDao


    private lateinit var albums: List<Album>
    private lateinit var artists: List<Artist>


}