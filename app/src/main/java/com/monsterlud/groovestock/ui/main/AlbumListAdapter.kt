package com.monsterlud.groovestock.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.ListItemAlbumBinding
import com.monsterlud.groovestock.inflate
import com.monsterlud.groovestock.models.Album

class AlbumListAdapter(
    context: Context,
    private val albums: List<Album>
) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder (
        val binding: ListItemAlbumBinding
    ) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemAlbumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
//        binding.root.setOnClickListener() {
//            Navigation.createNavigateOnClickListener(R.id.action_albumListFragment_to_albumDetailFragment)
//        }
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.binding.tvAlbumTitle.text = album.albumTitle
        holder.binding.tvArtist.text = album.albumArtist
        holder.binding.tvLabel.text = album.label
        holder.binding.tvReleased.text = album.released
        holder.binding.tvMedia.text = album.media.toString()
        holder.binding.tvGenre.text = album.genre.toString()

            }

    override fun getItemCount(): Int = albums.size

}