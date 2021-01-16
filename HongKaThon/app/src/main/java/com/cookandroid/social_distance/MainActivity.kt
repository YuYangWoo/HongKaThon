package com.cookandroid.social_distance

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cookandroid.social_distance.base.BaseActivity
import com.cookandroid.social_distance.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment).navController
    }

    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(R.id.mapFragment, R.id.mainFragment, R.id.itemDialog, R.id.informationFragment),
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

    private fun initSupportActionBar() {
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun initNavigationView() {
        with(binding) {
            navigation.setupWithNavController(navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

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
