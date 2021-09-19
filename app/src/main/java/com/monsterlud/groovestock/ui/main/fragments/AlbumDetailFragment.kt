package com.monsterlud.groovestock.ui.main.fragments

import android.os.Bundle
import android.text.TextUtils.indexOf
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
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
import com.monsterlud.groovestock.ui.main.viewmodels.AlbumDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


private const val TAG = "AlbumDetailFragment"

class AlbumDetailFragment : Fragment() {

    private var binding: FragmentAlbumDetailBinding? = null
    private var infoBinding: FragmentAlbumInfoBinding? = null
    val args: AlbumDetailFragmentArgs by navArgs()
    private lateinit var viewModel: AlbumDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.setTitle("Album Detail")

        //Get the ViewModel
        viewModel = ViewModelProvider(this).get(AlbumDetailViewModel::class.java)
        //Get the args
        //viewModel.albumId = args.albumId
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout(s) for this fragment
        binding = FragmentAlbumDetailBinding.inflate(
            inflater,
            container,
            false
        )
        infoBinding = binding!!.albumInfo

        //Set the array adapter for the media drop down menu

        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.list_item_media, viewModel.mediaTypes)
        infoBinding!!.actvMediaType.setAdapter(arrayAdapter)

        /**
         * If we are navigating from AlbumListFragment via Recyclerview
         * call inflateAlbumInfo() to fill in the EditTexts with the chosen album info
         * and set button clicks for "Delete" and "Update"
         */
        if (id != -1) {
            viewModel.album?.let { inflateAlbumInfo(it) }
            // DELETE
            binding!!.btnCancelDelete.setOnClickListener {
                viewModel.deleteAlbum()
                closeKeyboardAndBackPressed()
            }
            // UPDATE
            binding!!.btnAddUpdate.setOnClickListener {
                viewModel.album!!.albumTitle = infoBinding!!.etAlbumTitle.text.toString()
                viewModel.album!!.albumArtist = infoBinding!!.etArtist.text.toString()
                viewModel.album!!.label = infoBinding!!.etLabel.text.toString()
                viewModel.album!!.released = infoBinding!!.etReleased.text.toString()
                viewModel.album!!.media =
                    viewModel.getMediaEnumValueFromString(infoBinding!!.actvMediaType.text.toString())

                viewModel.updateAlbum(viewModel.album!!)

                closeKeyboardAndBackPressed()
            }
        }
        /**
         * If we are navigating from AlbumListFragment via FloatingActionButton
         * leave the EditTexts blank and set button clicks for "Cancel" and "Add"
         */
        else {
            // CANCEL
            binding!!.btnCancelDelete.setOnClickListener {
                closeKeyboardAndBackPressed()
            }
            // ADD
            binding!!.btnAddUpdate.setOnClickListener {
                val media =
                    viewModel.getMediaEnumValueFromString(infoBinding!!.actvMediaType.text.toString())
                val album = Album(
                    0,
                    infoBinding!!.etAlbumTitle.text.toString(),
                    infoBinding!!.etArtist.text.toString(),
                    infoBinding!!.etLabel.text.toString(),
                    infoBinding!!.etReleased.text.toString(),
                    media
                )
                viewModel.addAlbum(album)
                closeKeyboardAndBackPressed()
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
        val mediaType = viewModel.getMediaEnumValueFromOrdinal(media)
        infoBinding?.actvMediaType?.setText(mediaType.toString(), false)

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

    private fun closeKeyboardAndBackPressed() {
        activity?.let { it1 -> hideSoftKeyBoard(it1, binding!!.root) }
        activity?.onBackPressed()
    }
}