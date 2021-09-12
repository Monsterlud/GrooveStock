package com.monsterlud.groovestock

import android.app.Application

import android.util.Log
import com.monsterlud.groovestock.database.AlbumDatabase
import com.monsterlud.groovestock.database.repository.AlbumRepository
import com.monsterlud.groovestock.database.repository.AlbumRepositoryImpl
import com.monsterlud.groovestock.models.Album
import com.monsterlud.groovestock.models.Media

const val TAG = "App.kt"

class App : Application() {


    companion object {
        private lateinit var instance: App
        private val database: AlbumDatabase by lazy {
            AlbumDatabase.buildDatabase(instance)
        }

        val repository: AlbumRepository by lazy {
            AlbumRepositoryImpl(
                database.albumDao(),
                database.artistDao()
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        //For now, start with a clean database. Comment out for persistent data.
//        repository.deleteAllAlbums()

        if (repository.getAllAlbums().isEmpty()) {
            repository.addAlbums(
                listOf<Album>(
                    Album(0, "Folklore", "Taylor Swift", "2020", "Republic Records", Media.VINYL),
                    Album(0, "Reputation", "Taylor Swift", "2017", "Big Machine Records", Media.CD),
                    Album(0, "Pang", "Caroline Polachek", "2019", "Perpetual Novice", Media.MP3),
                    Album(0, "Art Angels", "Grimes", "2015", "4AD", Media.CD),
                    Album(0, "Pet Sounds", "The Beach Boys", "1966", "Capitol Records", Media.VINYL),
                    Album(0, "Rubber Soul", "The Beatles", "1965", "Capitol Records", Media.VINYL),
                    Album(0, "Conor Oberst", "Conor Oberst", "2008", "Merge Records", Media.CASSETTE),
                    Album(0, "Immunity", "Clairo", "2019", "Fader Lasbel", Media.MP3),
                    Album(0, "Blue Lines", "Massive Attack", "1991", "Wild Bunch Records", Media.CD),
                    Album(0, "Flaws", "Bombay Bicycle Club", "2010", "Island Records", Media.VINYL),
                    Album(0, "Revelations", "Sufjan Stevens", "2021", "Asthmatic Kitty", Media.MP3),
                    Album(0, "Dangerous Woman", "Ariana Grande", "2016", "Republic Records", Media.CASSETTE),
                    Album(0, "good kit, m.A.A.d city", "Kendrick Lamar", "2012", "Aftermath Entertainment", Media.VINYL),
                    Album(0, "The Chronic", "Dr. Dre", "1992", "Interscope Records", Media.CD),
                    Album(0, "Snail Mail", "Lush", "2018", "Matador", Media.VINYL)
                )
            )
        }
    }
}
