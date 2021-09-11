package com.monsterlud.groovestock.ui.main.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.monsterlud.groovestock.App
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.FragmentAlbumListBinding
import com.monsterlud.groovestock.ui.main.AlbumListAdapter


class AlbumListFragment : Fragment() {

    private lateinit var _binding: FragmentAlbumListBinding
    private val binding get() = _binding!!
    private var albums = App.repository.getAllAlbums()
    private val recyclerView = binding.albumRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = activity?.let { AlbumListAdapter(it, albums) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAlbumListBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        view.setOnClickListener() {
            Navigation.createNavigateOnClickListener(R.id.action_albumListFragment_to_albumDetailFragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}