package com.cookandroid.social_distance.dialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.navArgs
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseDialog
import com.cookandroid.social_distance.databinding.DialogOptionBinding

class OptionDialog(context: Context, check: String) : BaseDialog<DialogOptionBinding>(context,R.layout.dialog_option) {
private val check = check
    override fun init() {
        super.init()
        binding.info = this
        check()
    }

    private fun check() {
        when (check) {
            "앱 버전" -> {
                binding.txtContent.text = "앱버전 1.0"
            }
            "위치정보 이용약관" -> {
                binding.txtContent.text = "위치정보"

            }
            "오픈소스 라이선스" -> {
                binding.txtContent.text = "오픈소스"

            }
            "개발자 소개" -> {
                binding.txtContent.text = "유양우 & 강태종"

            }
            else -> {
                Log.d("ERROR", "존재하지 않는 설정")
            }
        }
    }
}