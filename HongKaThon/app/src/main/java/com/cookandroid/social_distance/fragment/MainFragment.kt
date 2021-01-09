package com.cookandroid.social_distance.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context.LOCATION_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cookandroid.social_distance.AreaFactory
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.MainActivity
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
private lateinit var gpsTracker:GpsTracker


    override fun init() {
        super.init()
        binding.root.findViewById<TextView>(R.id.address).also {
            gpsTracker = GpsTracker(requireContext())
            it.text = "현재 계신 곳은 ${gpsTracker.getArea().korean} 이고 거리두기 지침은 x단계 입니다. "
        }
    }
}




