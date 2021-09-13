package com.monsterlud.groovestock.ui.main.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.monsterlud.groovestock.App
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.FragmentAlbumDetailBinding
import com.monsterlud.groovestock.databinding.FragmentAlbumInfoBinding
import com.monsterlud.groovestock.models.Album
import com.monsterlud.groovestock.models.getAlbum
import com.monsterlud.groovestock.ui.main.fragments.AlbumDetailFragmentArgs.*


class AlbumDetailFragment : Fragment() {

    private var binding: FragmentAlbumDetailBinding? = null
    private var infoBinding: FragmentAlbumInfoBinding? = null
    val args: AlbumDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.setTitle("Album Detail")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get the arguments

        val id = args.albumId


        // Inflate the layout for this fragment
        binding = FragmentAlbumDetailBinding.inflate(
            inflater,
            container,
            false
        )
        if (id != -1) {
            val album = App.repository.getAllAlbums().getAlbum(id)
            inflateAlbumInfo(album)
        }
        return binding!!.root
    }


    private fun inflateAlbumInfo(album: Album) {

        infoBinding = binding!!.albumInfo

        infoBinding?.etAlbumTitle?.setText(album.albumTitle)
        infoBinding?.etArtist?.setText(album.albumArtist)
        infoBinding?.etLabel?.setText(album.label)
        infoBinding?.etReleased?.setText(album.released)
        infoBinding?.etMedia?.setText(album.media.toString())

        binding!!.btnAddUpdate.setText("Update")
        binding!!.btnCancelDelete.setText("Delete")
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}