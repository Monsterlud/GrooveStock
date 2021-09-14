package com.monsterlud.groovestock.ui.main.fragments

import android.os.Bundle
import android.text.TextUtils.indexOf
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.monsterlud.groovestock.App
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.FragmentAlbumDetailBinding
import com.monsterlud.groovestock.databinding.FragmentAlbumInfoBinding
import com.monsterlud.groovestock.hideSoftKeyBoard
import com.monsterlud.groovestock.models.Album
import com.monsterlud.groovestock.models.Media
import com.monsterlud.groovestock.models.getAlbum
import com.monsterlud.groovestock.ui.main.fragments.AlbumDetailFragmentArgs.*

private const val TAG = "AlbumDetailFragment"
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

        //Get the arguments
        val id = args.albumId


        //Inflate the layout(s) for this fragment
        binding = FragmentAlbumDetailBinding.inflate(
            inflater,
            container,
            false
        )
        infoBinding = binding!!.albumInfo

        //Set the array adapter for the media drop down menu
        val mediaTypes = Media.values()
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_item_media, mediaTypes)
        infoBinding!!.actvMediaType.setAdapter(arrayAdapter)

        /**
         * If we are navigating from AlbumListFragment via Recyclerview
         * call inflateAlbumInfo() to fill in the EditTexts with the chosen album info
         * and set button clicks for "Delete" and "Update"
         */
        if (id != -1) {
            val album = App.repository.getAllAlbums().getAlbum(id)
            inflateAlbumInfo(album)
            // DELETE
            binding!!.btnCancelDelete.setOnClickListener {
                App.repository.deleteAlbum(album)
                activity?.let { it1 -> hideSoftKeyBoard(it1, binding!!.root) }
                activity?.onBackPressed()
            }
            // UPDATE
            binding!!.btnAddUpdate.setOnClickListener {
                val media = getMediaEnumValueFromString(infoBinding!!.actvMediaType.text.toString())

                album.albumTitle = infoBinding!!.etAlbumTitle.text.toString()
                album.albumArtist = infoBinding!!.etArtist.text.toString()
                album.label = infoBinding!!.etLabel.text.toString()
                album.released = infoBinding!!.etReleased.text.toString()
                album.media = media

                App.repository.updateAlbum(album)

                activity?.let { it1 -> hideSoftKeyBoard(it1, binding!!.root) }
                activity?.onBackPressed()
            }
        }
        /**
         * If we are navigating from AlbumListFragment via FloatingActionButton
         * leave the EditTexts blank and set button clicks for "Cancel" and "Add"
         */
        else {
            // CANCEL
            binding!!.btnCancelDelete.setOnClickListener {
                activity?.let { it1 -> hideSoftKeyBoard(it1, binding!!.root) }
                activity?.onBackPressed()
            }
            // ADD
            binding!!.btnAddUpdate.setOnClickListener {
                val media = getMediaEnumValueFromString(infoBinding!!.actvMediaType.text.toString())
                val album = Album(
                    0,
                    infoBinding!!.etAlbumTitle.text.toString(),
                    infoBinding!!.etArtist.text.toString(),
                    infoBinding!!.etLabel.text.toString(),
                    infoBinding!!.etReleased.text.toString(),
                    media
                )
                App.repository.addAlbum(album)
                activity?.let { it1 -> hideSoftKeyBoard(it1, binding!!.root) }
                activity?.onBackPressed()
            }
        }
        return binding!!.root
    }


    private fun inflateAlbumInfo(album: Album) {

        infoBinding?.etAlbumTitle?.setText(album.albumTitle)
        infoBinding?.etArtist?.setText(album.albumArtist)
        infoBinding?.etLabel?.setText(album.label)
        infoBinding?.etReleased?.setText(album.released)
        val media = album.media.ordinal
        val mediaType = getMediaEnumValueFromOrdinal(media)
        infoBinding?.actvMediaType?.setText(mediaType.toString(), false)

        binding!!.btnAddUpdate.setText("Update")
        binding!!.btnCancelDelete.setText("Delete")
    }


    private fun getMediaEnumValueFromString(name: String) : Media {
        var media = Media.VINYL
        if (name == "VINYL") media = Media.VINYL
        else if (name == "CD") media = Media.CD
        else if (name == "MP3") media = Media.MP3
        else media = Media.CASSETTE

        return media
    }
    private fun getMediaEnumValueFromOrdinal(ordinal: Int) : Media {
        var media = Media.VINYL
        if (ordinal == 0) media = Media.VINYL
        else if (ordinal == 1) media = Media.CD
        else if (ordinal == 2) media = Media.MP3
        else media = Media.CASSETTE

        return media
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }



}