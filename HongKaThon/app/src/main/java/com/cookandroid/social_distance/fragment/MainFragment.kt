package com.cookandroid.social_distance.fragment

import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.social_distance.AreaFactory
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.ItemAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentMainBinding
import com.cookandroid.social_distance.singleton.CoronaData


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

    private fun setRecyclerView() {
        val itemAdapter = ItemAdapter(requireContext())
        binding.recyclerMain.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = itemAdapter
        }
        itemAdapter.data = AreaFactory.areaList
        itemAdapter.notifyDataSetChanged()
    }

}




