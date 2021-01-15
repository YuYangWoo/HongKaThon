package com.cookandroid.social_distance.dialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseDialog
import com.cookandroid.social_distance.databinding.DialogItemBinding

class ItemDialog(context: Context, private val itemName: String) : BaseDialog<DialogItemBinding>(context, R.layout.dialog_item) {
    private lateinit var level: String

    override fun init() {
        super.init()
        Log.d("test", itemName)
    }
}