package com.cookandroid.social_distance.dialog

import android.content.Context
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.view.View
import androidx.navigation.fragment.navArgs
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseDialog
import com.cookandroid.social_distance.databinding.DialogOptionBinding
import com.cookandroid.social_distance.item.OptionItem

class OptionDialog(context: Context, check: OptionItem) : BaseDialog<DialogOptionBinding>(context,R.layout.dialog_option) {
private val check = check
    override fun init() {
        super.init()
        binding.info = check
        if(check.title == "사용방법 및 앱 소개") {
            binding.txtContent.movementMethod = LinkMovementMethod.getInstance()
            binding.txtContent.autoLinkMask = Linkify.WEB_URLS
        }
    }
}