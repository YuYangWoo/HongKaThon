package com.cookandroid.social_distance.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.AreaAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentMainBinding
import com.cookandroid.social_distance.dialog.ProgressDialog
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.item.AreaItem
import com.cookandroid.social_distance.singleton.CoronaData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private lateinit var gpsTracker: GpsTracker
    private lateinit var callback: OnBackPressedCallback
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var areaList = ArrayList<AreaItem>()
    private val dialog by lazy { ProgressDialog(requireContext()) }

    // 마지막으로 뒤로가기 버튼을 눌렀던 시간 저장
    private var backKeyPressedTime: Long = 0

    // 첫 번째 뒤로가기 버튼을 누를때 표시
    private lateinit var toast: Toast
    override fun init() {
        super.init()
        adjust()
        setRecyclerView()
    }

    // 지역, 단계 크기 조정
    private fun adjust() {
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
    }

    // 리사이클러뷰 adapt
    private fun setRecyclerView() {
        // DB데이터 연결
        database.getReference("areaList")
            .addListenerForSingleValueEvent(object : ValueEventListener {

                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    areaList.clear()
                    val list = ArrayList<AreaItem>()
                    for (snapshot in dataSnapshot.children) { // 반복문으로 데이터 List를 추출해냄
                        snapshot.getValue(AreaItem::class.java)
                            ?.let { list.add(it) } // 만들어뒀던 객체에 데이터를 담는다.
                    }
                    areaList = list

                    with(binding.recyclerMain) {
                        adapter = AreaAdapter().apply {
                            data = areaList
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

                // 디비를 가져오던중 에러 발생 시 에러문 출력
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.e("Error", databaseError.toException().toString())
                }
            })

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
        inflater.inflate(R.menu.fragment_main, menu)
    }

    // 툴바기능 옵션메뉴 활성화
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    // 공유하기 활성화
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option -> {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToOptionFragment())
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}




