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
    val albumTitle: String,

    @ColumnInfo(name = "album_artist")
    val albumArtist: String
) {
    @ColumnInfo(name = "album_released")
    var released: String? = null

    @ColumnInfo(name = "album_label")
    var label: String? = null

    @ColumnInfo(name = "album_media")
    var media: Media? = null

    @ColumnInfo(name = "album_genre")
    var genre: Genre? = null

//    @ColumnInfo(name = "album_coverUrl")
//    val albumCoverUrl: String? = null

//    @ColumnInfo(name = "album_tracks")
//    var tracks: List<Track>? = null
}