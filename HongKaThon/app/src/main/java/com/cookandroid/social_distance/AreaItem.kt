package com.cookandroid.social_distance

import java.io.Serializable

data class AreaItem(
        var img: String,
        var name: String,
        var information: ArrayList<Level>
) : Serializable {
    constructor() : this("", "", arrayListOf())

    companion object {
        const val ONE = 0
        const val ONE_FIVE = 1
        const val TWO = 2
        const val TWO_FIVE = 3
        const val THREE = 4
    }

    data class Level(
            var one: String,
            var oneFive: String,
            var two: String,
            var twoFive: String,
            var three: String
    ) : Serializable {
        constructor() : this("", "", "", "", "")
    }
}
