package com.cookandroid.social_distance.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

abstract class BaseDialog<T : ViewDataBinding>(context: Context, val layoutId: Int) : Dialog(context) {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, null, false)
        init()
        setContentView(binding.root)
    }
    protected open fun init() {

    }
}