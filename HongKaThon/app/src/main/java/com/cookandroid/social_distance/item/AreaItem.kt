package com.cookandroid.social_distance.item

import java.io.Serializable

data class AreaItem(
        var img: String,
        var name: String,
        var information: List<String>
) : Serializable {
    constructor() : this("", "",  listOf())

    companion object {
        const val ONE = 0
        const val ONE_FIVE = 1
        const val TWO = 2
        const val TWO_FIVE = 3
        const val THREE = 4
    }
}
