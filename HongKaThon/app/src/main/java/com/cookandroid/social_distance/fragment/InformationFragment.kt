package com.cookandroid.social_distance.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.navArgs
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentInformationBinding

class InformationFragment : BaseFragment<FragmentInformationBinding>(R.layout.fragment_information) {

    private val args:InformationFragmentArgs by navArgs()
    override fun init() {
        super.init()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var name = args.name
        var level = args.level
        Log.d("test",name + level)
    }
}