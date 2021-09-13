package com.monsterlud.groovestock.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monsterlud.groovestock.databinding.ListItemAlbumBinding
import com.monsterlud.groovestock.models.Album
import kotlin.reflect.KFunction1

class AlbumListAdapter(
    context: Context,
    private val albums: List<Album>,
    private val onAlbumClick: KFunction1<Int, Unit>
) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(
        val binding: ListItemAlbumBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album, onAlbumClick: KFunction1<Int, Unit>) {
            binding.tvAlbumTitle.text = album.albumTitle
            binding.tvArtist.text = album.albumArtist
            binding.tvLabel.text = album.label
            binding.tvReleased.text = album.released
            binding.tvMedia.text = album.media.toString()

            binding.root.setOnClickListener { this@AlbumListAdapter.onAlbumClick(album.albumId) }
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
        holder.bind(albums[position], onAlbumClick)
    }

    override fun getItemCount(): Int = albums.size

}