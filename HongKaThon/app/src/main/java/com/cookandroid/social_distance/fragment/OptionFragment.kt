package com.cookandroid.social_distance.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.OptionAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentOptionBinding

class OptionFragment : BaseFragment<FragmentOptionBinding>(R.layout.fragment_option) {
    var optionList = arrayListOf("앱 버전", "위치정보 이용약관", "오픈소스 라이선스", "개발자 소개")
    override fun init() {
        super.init()

        setRecyclerView()
    }

    private fun setRecyclerView() {
        with(binding.optionRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = OptionAdapter().apply {
                data = optionList
                notifyDataSetChanged()
            }
        }
    }
}