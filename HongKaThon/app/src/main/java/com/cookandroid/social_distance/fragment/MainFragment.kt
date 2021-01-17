package com.cookandroid.social_distance.fragment

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.RelativeSizeSpan
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
            var address = "현재 계신 곳은 ${gpsTracker.getArea().korean}\n거리두기 지침은 ${CoronaData.getLevel(gpsTracker.getArea())}단계"
            var sps = SpannableStringBuilder(address)
            var word = arrayListOf(gpsTracker.getArea().korean, CoronaData.getLevel(gpsTracker.getArea()))

            for(i in 0..1) {
                var start = address.indexOf(word[i])
                var end = start + word[i].length
                sps.setSpan(RelativeSizeSpan(1.3f),start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            it.text = sps
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




