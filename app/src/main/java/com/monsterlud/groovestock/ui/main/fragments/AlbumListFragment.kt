package com.monsterlud.groovestock.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.monsterlud.groovestock.App
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.FragmentAlbumListBinding
import com.monsterlud.groovestock.ui.main.adapters.AlbumListAdapter
import com.monsterlud.groovestock.ui.main.viewmodels.AlbumListViewModel

private const val TAG = "AlbumListFragment"

class AlbumListFragment : Fragment() {

    private var binding: FragmentAlbumListBinding? = null
    var albumAdapter: AlbumListAdapter? = null
    private lateinit var viewModel: AlbumListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.setTitle("My GrooveStock")
        Log.i(TAG, "onCreate: Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(AlbumListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumListBinding.inflate(
            inflater,
            container,
            false
        )

        binding!!.albumAddFab.setOnClickListener {
            val action
            = AlbumListFragmentDirections.actionAlbumListFragmentToAlbumDetailFragment(-1)
            activity?.findNavController(R.id.nav_host_fragment_container)?.navigate(action)
        }

        val recyclerView = binding?.albumRecyclerView
        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            albumAdapter = activity?.let {
                AlbumListAdapter(it, viewModel.albums, ::onAlbumClick)
            }
            recyclerView.adapter = albumAdapter

        }
        return binding!!.root
    }

    private fun onAlbumClick(id: Int) {
        val action
        = AlbumListFragmentDirections.actionAlbumListFragmentToAlbumDetailFragment(id)
        activity?.findNavController(R.id.nav_host_fragment_container)?.navigate(action)
    }


    override fun onResume() {
        super.onResume()
        albumAdapter?.updateAdapter(App.repository.getAllAlbums())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val findAGroove = menu.findItem(R.id.action_findagroove)
        val searchCollection = menu.findItem(R.id.action_search)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}