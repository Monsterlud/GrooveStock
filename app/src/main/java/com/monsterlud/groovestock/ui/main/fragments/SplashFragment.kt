package com.monsterlud.groovestock.ui.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.monsterlud.groovestock.R
import kotlin.concurrent.thread

private val TAG = "Splash Fragment"

class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToMainActivity()
    }



    private fun navigateToMainActivity() {
//        findNavController()
//            .navigate(R.id.action_splashFragment_to_albumListFragment,
//                null,
//                NavOptions.Builder()
//                    .setPopUpTo(R.id.splashFragment, true).build())
    }
}
