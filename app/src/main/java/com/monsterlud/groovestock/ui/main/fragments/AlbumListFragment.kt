package com.monsterlud.groovestock.ui.main.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.monsterlud.groovestock.App
import com.monsterlud.groovestock.R
import com.monsterlud.groovestock.databinding.FragmentAlbumListBinding
import com.monsterlud.groovestock.ui.main.AlbumListAdapter
import com.monsterlud.groovestock.ui.main.MainActivity


class AlbumListFragment : Fragment() {

    private var binding: FragmentAlbumListBinding? = null
    private var albums = App.repository.getAllAlbums()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.setTitle("My GrooveStock")
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
        val recyclerView = binding?.albumRecyclerView

        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = activity?.let {
                AlbumListAdapter(it, albums, ::onAlbumClick)
            }
        }

        binding!!.albumAddFab.setOnClickListener {
            val action
            = AlbumListFragmentDirections.actionAlbumListFragmentToAlbumDetailFragment(-1)
            activity?.findNavController(R.id.nav_host_fragment_container)?.navigate(action)
        }
        return binding!!.root
    }

    private fun onAlbumClick(id: Int) {
        val action
        = AlbumListFragmentDirections.actionAlbumListFragmentToAlbumDetailFragment(id)
        activity?.findNavController(R.id.nav_host_fragment_container)?.navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_findagroove)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}