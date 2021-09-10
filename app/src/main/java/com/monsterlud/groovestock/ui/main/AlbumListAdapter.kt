package com.monsterlud.groovestock.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.inflate
import com.monsterlud.groovestock.models.Album

class AlbumListAdapter(
    private val albums: List<Album>
) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    class ViewHolder(
        v: View
    ) : RecyclerView.ViewHolder(v) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_album))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = albums.size


}