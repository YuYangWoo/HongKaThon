package com.cookandroid.social_distance.fragment

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.RelativeSizeSpan
import android.util.Log
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

        with(binding.address) {
            gpsTracker = GpsTracker(requireContext()) //객체 생성
            val address = "현재 계신 곳은 ${gpsTracker.getArea().korean}\n거리두기 지침은 ${CoronaData.getLevel(gpsTracker.getArea())}단계"
            val sps = SpannableStringBuilder(address)
            val word = arrayListOf(gpsTracker.getArea().korean, CoronaData.getLevel(gpsTracker.getArea()))

            // 지역과 단계 크기 1.3배 크게 하기
            for(i in word.indices) {
                val start = address.indexOf(word[i])
                val end = start + word[i].length
                sps.setSpan(RelativeSizeSpan(1.3f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            text = sps
        }

        setRecyclerView()
    }

    // 리사이클러뷰 adapt
    private fun setRecyclerView() {
        with(binding.recyclerMain) {
            adapter = ItemAdapter().apply {
                data = AreaFactory.areaList
                notifyDataSetChanged()
            }

            layoutManager = object : GridLayoutManager(context, 4) {
                override fun canScrollHorizontally(): Boolean {
                    return false
                }

                override fun canScrollVertically(): Boolean {
                    return false
                }
            }

            setHasFixedSize(true)
        }
    }

}




