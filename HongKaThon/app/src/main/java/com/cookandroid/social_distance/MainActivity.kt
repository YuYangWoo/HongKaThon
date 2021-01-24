package com.cookandroid.social_distance

import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cookandroid.social_distance.base.BaseActivity
import com.cookandroid.social_distance.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment).navController
    }

    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(R.id.mapFragment, R.id.mainFragment),
            binding.drawer
        )
    }

    // BackpressCloseHandler 객체화
    private val backPressCloseHandler = BackPressCloseHandler(this)

    override fun init() {
        super.init()
        initSupportActionBar()
        initNavigationView()
    }

    // 툴바 구현 + 툴바에 Controller와 appBarConfiguration 결합
    private fun initSupportActionBar() {
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // 네비게이션뷰와 navController 결합
    private fun initNavigationView() {
        with(binding) {
            navigation.setupWithNavController(navController)
        }
    }

    // AppBar에 생성되는 뒤로가기 버튼
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        Log.d("test", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test", "onStrop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("test", "onRestart")
    }

    // 뒤로 가기 버튼을 누르면
    override fun onBackPressed() {
        with(binding) {
            if (drawer.isDrawerOpen(navigation)) {
                drawer.closeDrawer(navigation)
            } else {
                super.onBackPressed()
            }
        }
    }
}
