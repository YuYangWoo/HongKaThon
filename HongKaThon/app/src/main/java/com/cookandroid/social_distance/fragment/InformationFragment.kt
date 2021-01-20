package com.cookandroid.social_distance.fragment

import android.content.Intent
import android.util.Log
import androidx.navigation.fragment.navArgs
import com.cookandroid.social_distance.AreaItem
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.ViewPagerAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentInformationBinding
import com.google.android.material.tabs.TabLayoutMediator

class InformationFragment :
    BaseFragment<FragmentInformationBinding>(R.layout.fragment_information) {
    private val args: InformationFragmentArgs by navArgs()
    private lateinit var now: String

    private val level: Array<Int> by lazy {
        arrayOf(
            R.string.ONE,
            R.string.ONE_FIVE, R.string.TWO, R.string.TWO_FIVE, R.string.THREE
        )
    }

    private lateinit var areaItem: AreaItem
    override fun init() {
        super.init()
        // 데이터 전달
        areaItem = args.checkItem
        now = args.level
        convert()
        Log.d("test", now)
        initViewPager()
        initTabLayoutMediator()
        btnClick()
        binding.info = areaItem
    }

    private fun initViewPager() {
        with(binding.viewPager2) {
            adapter = ViewPagerAdapter().apply {
                data = areaItem
            }
            setCurrentItem(now.toInt(),true)
        }
    }

    private fun initTabLayoutMediator() {
        TabLayoutMediator(binding.tabLy, binding.viewPager2) { tab, position ->
            tab.text = getString(level[position])
        }.attach()
    }

    private fun btnClick() {
        binding.setOnBtnClick {
            when (it.id) {
                R.id.btnShare -> {
                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, "${areaItem.name}\n${areaItem.information[now.toInt()]}")
                    }
                    startActivity(shareIntent)

                }
            }
        }
    }

    private fun convert() {
        when (now) {
            "1" -> {
                now = AreaItem.ONE.toString()
            }
            "1.5" -> {
                now=AreaItem.ONE_FIVE.toString()
            }
            "2" -> {
                now=AreaItem.TWO.toString()
            }
            "2.5" -> {
                now =AreaItem.TWO_FIVE.toString()
            }
            "3" -> {
                now=AreaItem.THREE.toString()
            }
        }
    }

}

