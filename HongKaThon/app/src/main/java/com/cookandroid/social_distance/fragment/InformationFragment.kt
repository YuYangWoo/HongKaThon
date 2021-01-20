package com.cookandroid.social_distance.fragment

import android.content.Intent
import android.util.Log
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.cookandroid.social_distance.AreaItem
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.ViewPagerAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentInformationBinding

class InformationFragment : BaseFragment<FragmentInformationBinding>(R.layout.fragment_information) {
    private val args: InformationFragmentArgs by navArgs()
    private lateinit var action: NavDirections
    private lateinit var areaItem: AreaItem
    override fun init() {
        super.init()

//        initTabLayoutMediator()
         areaItem = args.checkItem
        Log.d("test", areaItem.information[0])
        initViewPager()
        btnclick()
        binding.info = areaItem
    }

    private fun initViewPager() {
        with(binding.viewPager2) {
            adapter = ViewPagerAdapter().apply {
                data = areaItem
            }
        }

    }

//    private fun initTabLayoutMediator() {
//        TabLayoutMediator(binding.tabLy, binding.viewPager2) { tab, position ->
//            tab.text = getString(levelList[position].tabTitle)
//        }.attach()
//    }

    private fun btnclick() {
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

