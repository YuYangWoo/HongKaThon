package com.cookandroid.social_distance

import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.cookandroid.social_distance.base.BaseActivity
import com.cookandroid.social_distance.databinding.ActivitySplashBinding
import com.cookandroid.social_distance.singleton.AreaFactory


class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val splashTime: Long = 1000

    override fun init() {
        super.init()
        check()
    }

    // 위치기능 on/off 확인
    private fun check() {
        if (!checkLocationServicesStatus()) {
            showDialogForLocationServiceSetting()
        } else {
            requestRuntimePermissions()
        }
    }

    // 위치 권한 요청
    private fun requestRuntimePermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }

        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            // 2초 지나고 화면 전환
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, splashTime)
        } else {
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_CODE)

        }
    }

    // 권한 요청 결과 받기
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isEmpty()) {
                    throw RuntimeException("권한이 비어있습니다.")
                }
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // 2초 지나고 화면 전환
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }, splashTime)
                } else {
                    if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                        Log.d(TAG, "사용자가 권한요청을 거부했습니다. 계속 요청하겠습니다.")
                        requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                            PERMISSION_REQUEST_CODE)

                    } else {
                        Log.d(TAG, "사용자가 거절했습니다.")
                        showDialogToGetPermission()
                    }
                }
            }
        }
    }

    // 다이얼로그로 권한 얻기
    private fun showDialogToGetPermission() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("권한 요청")
                .setMessage("앱을 사용하기 위해서는 권한 요청이 필요합니다. " +
                        "OK를 누르면 권한 설정 창으로 이동합니다.")
        builder.setPositiveButton("OK") { dialogInterface, i ->
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", packageName, null))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        builder.setNegativeButton("Later") { dialogInterface, i ->
            // ignore
        }
        val dialog = builder.create()
        dialog.show()
    }

    // GPS 설정으로 이동
    private fun showDialogForLocationServiceSetting() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("위치 서비스 비활성화")
        builder.setMessage(
                """
                앱을 사용하기 위해서는 위치 서비스가 필요합니다.
                위치 서비스를 설정하시려면 설정을 눌러주세요
                """.trimIndent()
        )
        builder.setCancelable(true)
        builder.setPositiveButton("설정") { dialog, id ->
            val callGPSSettingIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE)
        }
        builder.setNegativeButton("취소"
        ) { dialog, id -> dialog.cancel() }
        builder.create().show()

    }

    // 위치 서비스 상태확인
    private fun checkLocationServicesStatus(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        return (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
    }

    companion object {
        private const val GPS_ENABLE_REQUEST_CODE = 2001
        const val TAG = "SplashActivity"
        const val PERMISSION_REQUEST_CODE = 1001
    }

}