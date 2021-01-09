package com.cookandroid.social_distance

data class AreaItem(
    var img : String,
    var name: String ,
    var one: String ,
    var onedotfive: String,
    var threestep: String ,
    var twostep: String ,
    var twodotfivestep: String
) {
    constructor() : this("", "", "", "", "", "", "")
}