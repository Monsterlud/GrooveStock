package com.monsterlud.groovestock

import android.app.Application

import android.util.Log
import com.monsterlud.groovestock.database.AlbumDatabase
import com.monsterlud.groovestock.database.repository.AlbumRepository
import com.monsterlud.groovestock.database.repository.AlbumRepositoryImpl
import com.monsterlud.groovestock.models.Album

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
                    Album(0, "Folklore", "Taylor Swift"),
                    Album(0, "Reputation", "Taylor Swift"),
                    Album(0, "Pang", "Caroline Polachek"),
                    Album(0, "Art Angels", "Grimes"),
                    Album(0, "Pet Sounds", "The Beach Boys"),
                    Album(0, "Rubber Soul", "The Beatles"),
                    Album(0, "Conor Oberst", "Conor Oberst"),
                    Album(0, "Immunity", "Clairo"),
                    Album(0, "Blue Lines", "Massive Attack"),
                    Album(0, "Flaws", "Bombay Bicycle Club"),
                    Album(0, "Revelations", "Sufjan Stevens"),
                    Album(0, "Dangerous Woman", "Ariana Grande"),
                    Album(0, "good kit, m.A.A.d city", "Kendrick Lamar"),
                    Album(0, "The Chronic", "Dr. Dre"),
                    Album(0, "Snail Mail", "Lush")
                )
            )
        }
    }
}
