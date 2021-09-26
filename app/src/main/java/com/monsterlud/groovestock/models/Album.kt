package com.monsterlud.groovestock.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album_data_table")
data class Album(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "album_id")
    val albumId: Int,

    @ColumnInfo(name = "album_title")
    var albumTitle: String,

    @ColumnInfo(name = "album_artist")
    var albumArtist: String,

    @ColumnInfo(name = "album_released")
    var released: String,

    @ColumnInfo(name = "album_label")
    var label: String,

    @ColumnInfo(name = "album_media")
    var media: Media,

    ) {

    @ColumnInfo(name = "album_notes")
    var notes: String? = null

}
    fun List<Album>.getAlbum(id: Int) = find { it.albumId == id } ?: error("Album Not Found")


