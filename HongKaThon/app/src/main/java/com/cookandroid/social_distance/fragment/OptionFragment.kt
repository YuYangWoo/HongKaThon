package com.cookandroid.social_distance.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.OptionAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentOptionBinding
import com.cookandroid.social_distance.item.OptionItem

class OptionFragment : BaseFragment<FragmentOptionBinding>(R.layout.fragment_option) {
    var optionList = ArrayList<OptionItem>()
    override fun init() {
        super.init()

        initOptionItem()
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
    private fun initOptionItem() {
        optionList = arrayListOf(
            OptionItem("앱 버전","앱버전1.0"),
        OptionItem("위치정보 이용약관","위치제공한다."),
        OptionItem("오픈소스 라이선스","어쩌구저쩌구"),
        OptionItem("개발자 소개", "양유와 강태종")
        )
    }
 }