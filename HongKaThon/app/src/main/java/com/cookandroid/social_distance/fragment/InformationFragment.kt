package com.cookandroid.social_distance.fragment

import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
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
    private lateinit var callback: OnBackPressedCallback
    override fun init() {
        super.init()
        // 데이터 전달
        areaItem = args.checkItem
        now = args.level
        convert()
        initViewPager()
        initTabLayoutMediator()
        btnClick()
        binding.info = areaItem
    }

    // 뷰페이저 adapter
    private fun initViewPager() {
        with(binding.viewPager2) {
            adapter = ViewPagerAdapter().apply {
                data = areaItem
            }
            setCurrentItem(now.toInt(), true)
        }
    }

    // Tablayout Viewpager와 연결
    private fun initTabLayoutMediator() {
        TabLayoutMediator(binding.tabLy, binding.viewPager2) { tab, position ->
            tab.text = getString(level[position])
        }.attach()
    }

    // Button 클릭 이벤트
    private fun btnClick() {
        binding.setOnBtnClick {
            when (it.id) {
                R.id.btnShare -> {
                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(
                            Intent.EXTRA_TEXT,
                            "${areaItem.name}\n${areaItem.information[now.toInt()]}"
                        )
                    }
                    startActivity(shareIntent)
                }
            }
        }
    }

    // 현재 단계에 맞게 변환
    private fun convert() {
        when (now) {
            "1" -> {
                now = AreaItem.ONE.toString()
            }
            "1.5" -> {
                now = AreaItem.ONE_FIVE.toString()
            }
            "2" -> {
                now = AreaItem.TWO.toString()
            }
            "2.5" -> {
                now = AreaItem.TWO_FIVE.toString()
            }
            "3" -> {
                now = AreaItem.THREE.toString()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(InformationFragmentDirections.actionInformationFragmentToMainFragment())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }
}

