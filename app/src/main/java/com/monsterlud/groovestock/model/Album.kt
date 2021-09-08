package com.monsterlud.groovestock.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album_data_table")
class Album(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "album_id")
    val albumId: Int,

    @ColumnInfo(name = "album_title")
    val albumTitle: String,

    @ColumnInfo(name = "album_artist")
    val albumArtist: String
) {


}