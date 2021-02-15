package com.cookandroid.social_distance.dialog

import android.content.Context
import android.view.Window
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseDialog
import com.cookandroid.social_distance.databinding.DialogLoadingBinding

class ProgressDialog(context: Context) : BaseDialog<DialogLoadingBinding>(context, R.layout.dialog_loading) {
    override fun init() {
        super.init()
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }
}