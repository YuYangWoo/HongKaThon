package com.cookandroid.social_distance.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.social_distance.AreaFactory
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.MainActivity
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.ItemAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentMainBinding
import com.cookandroid.social_distance.dialog.ItemDialog
import com.cookandroid.social_distance.singleton.CoronaData
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
private lateinit var gpsTracker:GpsTracker
    override fun init() {
        super.init()
        binding.root.findViewById<TextView>(R.id.address).also {
            gpsTracker = GpsTracker(requireContext())
            it.text = "현재 계신 곳은 ${gpsTracker.getArea().korean} 이고 거리두기 지침은 ${CoronaData.getLevel(gpsTracker.getArea())}단계 입니다. "
        }

        setRecyclerView()

    }

    fun setRecyclerView() {
        val itemAdapter = ItemAdapter(requireContext())
        binding.recyclerMain.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = itemAdapter
        }
        itemAdapter.data = AreaFactory.areaList
        itemAdapter.notifyDataSetChanged()
    }

}




