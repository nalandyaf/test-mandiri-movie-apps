package com.test.movie.presentation.screen

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.test.movie.R
import com.test.movie.databinding.ActivityMainBinding
import com.test.movie.util.Constants
import com.test.movie.util.isDarkColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        updateThemeAndStatusBarOnDestinationChange(binding, navController)
    }

    private fun updateThemeAndStatusBarOnDestinationChange(
        binding: ActivityMainBinding,
        navController: NavController
    ) {
        with(WindowInsetsControllerCompat(window, window.decorView)) {
            navController.addOnDestinationChangedListener { _, destination, bundle ->
                window.statusBarColor = when (destination.id) {
                    R.id.searchFragment -> {
                        setTheme(R.style.Theme_MovieApp)
                        WindowCompat.setDecorFitsSystemWindows(window, true)
                        isAppearanceLightStatusBars = true

                        when (Build.VERSION.SDK_INT) {
                            21, 22 -> Color.BLACK
                            else -> ContextCompat.getColor(this@MainActivity, R.color.day_night_inverse)
                        }
                    }

                    else -> {
                        val backgroundColor = bundle?.getInt(Constants.BACKGROUND_COLOR) ?: 0
                        val isDarkBackground = backgroundColor.isDarkColor()

                        when (destination.id) {
//                            R.id.fullscreenImageFragment -> {
//                                WindowCompat.setDecorFitsSystemWindows(window, true)
//                                Color.BLACK
//                            }
//
//                            R.id.seeAllFragment -> {
//                                WindowCompat.setDecorFitsSystemWindows(window, true)
//
//                                if (backgroundColor != 0) {
//                                    setTheme(if (isDarkBackground) R.style.DetailDarkTheme else R.style.DetailLightTheme)
//                                    isAppearanceLightStatusBars = !isDarkBackground
//                                    backgroundColor
//                                } else {
//                                    setTheme(R.style.Theme_MovieApp)
//                                    isAppearanceLightStatusBars = true
//                                    if (Build.VERSION.SDK_INT in 21..22) Color.BLACK
//                                    else ContextCompat.getColor(this@MainActivity, R.color.day_night_inverse)
//                                }
//                            }
                            else -> {
                                window.statusBarColor = backgroundColor
                                WindowCompat.setDecorFitsSystemWindows(window, false)
                                setTheme(if (isDarkBackground) R.style.DetailDarkTheme else R.style.DetailLightTheme)
                                isAppearanceLightStatusBars = !isDarkBackground
                                Color.TRANSPARENT
                            }
                        }
                    }
                }
            }
        }
    }
}