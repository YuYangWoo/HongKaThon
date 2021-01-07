package com.cookandroid.social_distance

import android.app.Activity
import android.os.Process
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// 뒤로가기 버튼 2번을 누르면 Toast 메시지 후 종료
class BackPressCloseHandler(private val activity: Activity) : AppCompatActivity() {
    private var backKeyPressedTime: Long = 0
    private val timeInterval: Long = 2000
    private var toast: Toast? = null

    // 뒤로가기 알고리즘 구현
    override fun onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + timeInterval) {
            backKeyPressedTime = System.currentTimeMillis()
            showGuide()
        } else {
            toast!!.cancel()
            activity.moveTaskToBack(true) // 태스크를 백그라운드로 이동
            activity.finishAndRemoveTask() // 액티비티 종료 + 태스크 리스트에서 지우기
            Process.killProcess(Process.myPid()) // 앱 프로세스 종료
        }
    }

    // Toast 메시지 출력
    private fun showGuide() {
        toast = Toast.makeText(activity, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)
        toast!!.show()
    }

}