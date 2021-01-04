package com.cookandroid.social_distance.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentMapBinding

class MapFragment : BaseFragment<FragmentMapBinding>(R.layout.fragment_map) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_map_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.infection -> {
                binding.graph.setSocialInfection()
                true
            }
            R.id.level -> {
                binding.graph.setSocialDistanceLevel()
                true
            }
            R.id.filter -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}