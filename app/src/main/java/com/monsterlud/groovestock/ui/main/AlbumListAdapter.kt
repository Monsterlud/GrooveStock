package com.monsterlud.groovestock.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.ListItemAlbumBinding
import com.monsterlud.groovestock.inflate
import com.monsterlud.groovestock.models.Album

class AlbumListAdapter(
    private val context: Context,
    private val albums: List<Album>
    ) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder constructor(
        binding: ListItemAlbumBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val albumTitle = binding.tvAlbumTitle
        private val albumArtist = binding.tvArtist
        private val albumLabel = binding.tvLabel
        private val albumReleased = binding.tvRelease
        private val albumMedia = binding.tvMedia
        private val albumGenre = binding.tvGenre


        fun bind(album: Album) {
            albumTitle.text = album.albumTitle
            albumArtist.text = album.albumArtist
            albumLabel.text = album.label
            albumReleased.text = album.released
            albumMedia.text = album.genre.toString()
            albumGenre.text = album.media.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
    }

    override fun getItemCount(): Int = albums.size




}