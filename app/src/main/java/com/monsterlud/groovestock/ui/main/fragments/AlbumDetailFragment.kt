package com.monsterlud.groovestock.ui.main.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.FragmentAlbumDetailBinding


class AlbumDetailFragment : Fragment() {

    private var binding: FragmentAlbumDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding!!.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}