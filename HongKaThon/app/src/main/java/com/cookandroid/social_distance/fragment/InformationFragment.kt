package com.cookandroid.social_distance.fragment

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentInformationBinding
import com.cookandroid.social_distance.fragment.level.*
import com.google.android.material.tabs.TabLayoutMediator

class InformationFragment :
    BaseFragment<FragmentInformationBinding>(R.layout.fragment_information) {
    private val fragments by lazy {
        arrayOf(OneFragment(), OneFiveFragment(), TwoFragment(), TwoFiveFragment(), ThreeFragment())
    }
    private lateinit var action: NavDirections
    override fun init() {
        super.init()
        initViewPager()
        initTabLayoutMediator()
        btnBack()
    }

    private fun initViewPager() {
        binding.viewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

        }
    }

    private fun initTabLayoutMediator() {
        TabLayoutMediator(binding.tabLy, binding.viewPager2) { tab, position ->
            tab.text = getString(fragments[position].tabTitle)
        }.attach()
    }

    private fun btnBack() {
        binding.setOnBtnClick {
            when (it.id) {
                R.id.btnBack -> {
                    action = InformationFragmentDirections.actionInformationFragmentToMainFragment()
                    findNavController().navigate(action)
                }
                R.id.btnShare -> {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
//                putExtra(Intent.EXTRA_TEXT, "${checkedList[0].checkName}\n${checkedList[0].checkContent}")
            }
            startActivity(shareIntent)

    }
                }
            }
        }
    }

