package com.cookandroid.social_distance.fragment

import android.content.Intent
import android.util.Log
import androidx.navigation.fragment.navArgs
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.SplashActivity
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentInformationBinding

class InformationFragment : BaseFragment<FragmentInformationBinding>(R.layout.fragment_information) {
    var itemList =SplashActivity().areaList
    var checkedList = ArrayList<CheckItem>()
    private val args:InformationFragmentArgs by navArgs()
    lateinit var name: String
    lateinit var level: String
    override fun init() {
        super.init()

        //데이터 가져오기
        name = args.name
        level = args.level

        check()
        shareBtn()

        // 데이터 바인딩
        binding.check = checkedList[0]

    }
    // 체크된 아이템 클래스
    data class CheckItem(
        var checkname:String,
        var checkContent:String,
        var checkImg:String
    )

    // 이름과 단계로 시설 체크
    private fun check() {
        for(i in itemList.indices) {
            if(itemList[i].name == name) {
                when (level) {
                    "1단계" -> {
                        checkedList = arrayListOf(CheckItem(itemList[i].name, itemList[i].one, itemList[i].img))
                    }
                    "1.5단계" -> {
                        checkedList = arrayListOf(CheckItem(itemList[i].name, itemList[i].onedotfive, itemList[i].img))
                    }
                    "2단계" -> {
                        checkedList = arrayListOf(CheckItem(itemList[i].name, itemList[i].twostep, itemList[i].img))
                    }
                    "2.5단계" -> {
                        checkedList = arrayListOf(CheckItem(itemList[i].name, itemList[i].twodotfivestep, itemList[i].img))
                    }
                    "3단계" -> {
                        checkedList = arrayListOf(CheckItem(itemList[i].name, itemList[i].threestep, itemList[i].img))
                    }
                    else -> {
                        Log.d("Error", "참조하지 못하는 인덱스")
                    }
                }
            }
        }
    }

    // 공유하기 버튼
    private fun shareBtn() {
        binding.btnShare.setOnClickListener {
        var shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "${checkedList[0].checkname}\n${checkedList[0].checkContent}")
        startActivity(shareIntent)
        }
    }

}