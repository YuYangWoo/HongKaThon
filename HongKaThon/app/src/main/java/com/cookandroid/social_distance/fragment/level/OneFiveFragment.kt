package com.cookandroid.social_distance.fragment.level

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.fragment.LevelFragment

class OneFiveFragment : LevelFragment() {
    override val tabTitle: Int
        get() = R.string.ONE_FIVE

    override fun backBtn() {

        binding.setOnLevelClick {
            Toast.makeText(context, "눌림",Toast.LENGTH_LONG).show()
            findNavController().navigate(OneFiveFragmentDirections.actionOneFiveFragmentToMainFragment())
        }

    }
}