package com.cookandroid.social_distance

data class AreaItem(
    var img : String,
    var name: String ,
    var one: String ,
    var onedotfive: String,
    var threestep: String ,
    var twostep: String ,
    var twodotfivestep: String
    /*
    informatin: String[]
    0 => 1단계 정보
    1 => 1.5단계 정보
    2 => 2단계 정보
    3 => 2.5단계 정보
    4 => 3단계 정보
     */
) {

    /*
    companion object
    const val ONE = 0
    const val ONE_DOT_FIVE = 1
    .
    .
    .

    information[ONE_DOT_FIVE]  vs  information[1] ?? => companion이 보기 좋다.
     */
    constructor() : this("", "", "", "", "", "", "")
}