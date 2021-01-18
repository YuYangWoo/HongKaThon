package com.cookandroid.social_distance.dialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseDialog
import com.cookandroid.social_distance.databinding.DialogItemBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_item.*
import kotlinx.android.synthetic.main.dialog_item.view.*

class ItemDialog : BaseDialog<DialogItemBinding>(R.layout.dialog_item) {
    private lateinit var level: String
    private lateinit var itemName: String

   private val args : ItemDialogArgs by navArgs()
    override fun init() {
        super.init()
        binding.dialog = this
        itemName = args.Name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         btn()
    }

    // 버튼 클릭 이벤트
    private fun btn() {
        binding.btnOne.setOnClickListener {
            level = binding.btnOne.text.toString()
            var action = ItemDialogDirections.actionItemDialogToInformationFragment(level, itemName)
            getFragmentNavController(R.id.fragment)!!.navigate(action)
        }
        binding.btnOneFive.setOnClickListener {
            level = binding.btnOneFive.text.toString()
            var action = ItemDialogDirections.actionItemDialogToInformationFragment(level, itemName)
            getFragmentNavController(R.id.fragment)!!.navigate(action)
        }
        binding.btnTwo.setOnClickListener {
            level = binding.btnTwo.text.toString()
            var action = ItemDialogDirections.actionItemDialogToInformationFragment(level, itemName)
            getFragmentNavController(R.id.fragment)!!.navigate(action)
        }
        binding.btnTwoFive.setOnClickListener {
            level = binding.btnTwoFive.text.toString()
            var action = ItemDialogDirections.actionItemDialogToInformationFragment(level, itemName)
            getFragmentNavController(R.id.fragment)!!.navigate(action)
        }
        binding.btnThree.setOnClickListener {
            level = binding.btnThree.text.toString()
            var action = ItemDialogDirections.actionItemDialogToInformationFragment(level, itemName)
            getFragmentNavController(R.id.fragment)!!.navigate(action)
        }
    }

    // NavController 호출
    private fun Fragment.getFragmentNavController(@IdRes id: Int) = activity?.let {
        return@let Navigation.findNavController(it, id)
    }
}