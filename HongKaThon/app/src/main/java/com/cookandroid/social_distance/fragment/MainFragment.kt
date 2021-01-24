package com.cookandroid.social_distance.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.social_distance.AreaFactory
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.AreaAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentMainBinding
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.singleton.CoronaData


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private lateinit var gpsTracker: GpsTracker
    private lateinit var callback: OnBackPressedCallback

    // 마지막으로 뒤로가기 버튼을 눌렀던 시간 저장
    private var backKeyPressedTime: Long = 0

    // 첫 번째 뒤로가기 버튼을 누를때 표시
    private lateinit var toast: Toast
    override fun init() {
        super.init()

        with(binding.address) {
            gpsTracker = GpsTracker(requireContext()) //객체 생성
            val address = "현재 계신 곳은 ${gpsTracker.getArea().korean}\n거리두기 지침은 ${
                CoronaData.getLevel(
                    gpsTracker.getArea()
                )
            }단계"
            val sps = SpannableStringBuilder(address)
            val word = arrayListOf(
                gpsTracker.getArea().korean,
                CoronaData.getLevel(gpsTracker.getArea())
            )

            // 지역과 단계 크기 1.3배 크게 하기
            for (i in word.indices) {
                val start = address.indexOf(word[i])
                val end = start + word[i].length
                sps.setSpan(
                    RelativeSizeSpan(1.3f),
                    start,
                    end,
                    SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            text = sps
        }
        setRecyclerView()
    }

    // 리사이클러뷰 adapt
    private fun setRecyclerView() {
        with(binding.recyclerMain) {
            adapter = AreaAdapter().apply {
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

    // BackPressed 이벤트 정의
    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                    backKeyPressedTime = System.currentTimeMillis();
                    toast = Toast.makeText(
                        requireContext(),
                        "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.",
                        Toast.LENGTH_SHORT
                    );
                    toast.show();
                    return;
                }

                if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                    requireActivity().finish();
                    toast.cancel();
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    // 프래그먼트 떨어질 때 callback메서드 삭제
    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    // 툴바메뉴 활성화
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_information_menu, menu)
    }

    // 툴바기능 옵션메뉴 활성화
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    // 공유하기 활성화
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.option -> {

                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}




