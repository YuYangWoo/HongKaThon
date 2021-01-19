package com.cookandroid.social_distance.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cookandroid.social_distance.AreaFactory
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentInformationBinding
import com.cookandroid.social_distance.databinding.FragmentLevelBinding
import com.cookandroid.social_distance.fragment.level.*
import com.google.android.material.tabs.TabLayoutMediator

abstract class LevelFragment : BaseFragment<FragmentLevelBinding>(R.layout.fragment_level) {
    private val itemList = AreaFactory.areaList
    private lateinit var viewPager: ViewPager2
    abstract val tabTitle: Int

    override fun init() {
        super.init()
    }





//    private fun backBtn() {
//        binding.btnBack.setOnClickListener {
//            var action = LevelFragmentDirections.actionInformationFragmentToMainFragment()
//            findNavController().navigate(action)
//        }
//    }
//    // 공유하기 버튼
//    private fun shareBtn() {
//        binding.btnShare.setOnClickListener {
//            val shareIntent = Intent(Intent.ACTION_SEND).apply {
//                type = "text/plain"
//                putExtra(Intent.EXTRA_TEXT, "${checkedList[0].checkName}\n${checkedList[0].checkContent}")
//            }
//
//            startActivity(shareIntent)
//        }
//    }

}