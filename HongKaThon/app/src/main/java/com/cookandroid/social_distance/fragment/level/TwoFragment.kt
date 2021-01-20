package com.cookandroid.social_distance.fragment.level
import androidx.navigation.fragment.findNavController
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.fragment.LevelFragment

class TwoFragment : LevelFragment() {
    override val tabTitle: Int
        get() = R.string.TWO
    override fun backBtn() {
        binding.setOnLevelClick {
            findNavController().navigate(TwoFragmentDirections.actionTwoFragmentToMainFragment())
        }
    }
}