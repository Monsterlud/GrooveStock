package com.monsterlud.groovestock.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist_data_table")
data class Artist(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "artist_id")
    val artistId: Int,

    @ColumnInfo(name = "artist_name")
    val artistName: String
) {
}