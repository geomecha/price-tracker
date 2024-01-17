package com.geomecha.pricetracker.presentation.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.geomecha.pricetracker.R
import com.geomecha.pricetracker.core.delegate.viewBinding
import com.geomecha.pricetracker.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> {
                    navController.navigate(R.id.profile)
                    binding.topAppBar.title = getString(R.string.profile)
                    true
                }
                else -> false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        setNavSettings()
    }

    private fun setNavSettings() {
        binding.bottomNavigation.apply {
            setupWithNavController(navController)
            setOnItemSelectedListener { item ->
                onNavigationItemSelected(item)
            }
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.homeFragment -> {
                navController.navigate(R.id.homeFragment)
                binding.topAppBar.title = getString(R.string.home)
                true
            }
            R.id.favouritesFragment -> {
                navController.navigate(R.id.favouritesFragment)
                binding.topAppBar.title = getString(R.string.favourites)
                true
            }
            else -> false
        }
    }
}