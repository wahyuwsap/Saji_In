package com.saji_in

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnHome: ImageButton
    private lateinit var btnLove: ImageButton
    private lateinit var btnProfile: ImageButton
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        btnHome = findViewById(R.id.btn_home)
        btnLove = findViewById(R.id.btn_love)
        btnProfile = findViewById(R.id.btn_profile)

        // Initialize Navigation Controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController

        // Set initial selection
        setSelectedButton(btnHome)

        // Set click listeners
        btnHome.setOnClickListener {
            navigateToFragment(R.id.navigation_home, btnHome)
        }

        btnLove.setOnClickListener {
            navigateToFragment(R.id.navigation_love, btnLove)
        }

        btnProfile.setOnClickListener {
            navigateToFragment(R.id.navigation_profile, btnProfile)
        }
    }

    private fun navigateToFragment(destinationId: Int, selectedButton: ImageButton) {
        // Navigate to fragment
        navController.navigate(destinationId)

        // Update button selection
        setSelectedButton(selectedButton)
    }

    private fun setSelectedButton(selectedButton: ImageButton) {
        // Reset all buttons
        btnHome.isSelected = false
        btnLove.isSelected = false
        btnProfile.isSelected = false

        // Set selected button
        selectedButton.isSelected = true
    }
}