package com.saji_in

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.saji_in.model.SharedViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var btnHome: ImageButton
    private lateinit var btnLove: ImageButton
    private lateinit var btnProfile: ImageButton
    private lateinit var navController: NavController

    private var userId: Int = -1

    // SharedViewModel global
    val sharedViewModel: SharedViewModel by viewModels()

    companion object {
        lateinit var sharedViewModelRef: SharedViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Simpan referensi global ke SharedViewModel
        sharedViewModelRef = sharedViewModel

        // Ambil user_id dari intent
        userId = intent.getIntExtra("user_id", -1)

        // Init views
        btnHome = findViewById(R.id.btn_home)
        btnLove = findViewById(R.id.btn_love)
        btnProfile = findViewById(R.id.btn_profile)

        // Setup nav controller
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController

        // Kirim user_id ke graph
        val bundle = Bundle()
        bundle.putInt("user_id", userId)
        navController.setGraph(R.navigation.mobile_navigation, bundle)

        // Set default
        setSelectedButton(btnHome)

        btnHome.setOnClickListener {
            navigateToFragment(R.id.navigation_home, btnHome)
        }

        btnLove.setOnClickListener {
            navigateToFragment(R.id.navigation_love, btnLove)
        }

        btnProfile.setOnClickListener {
            navigateToFragment(R.id.navigation_profile, btnProfile)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> setSelectedButton(btnHome)
                R.id.navigation_love -> setSelectedButton(btnLove)
                R.id.navigation_profile -> setSelectedButton(btnProfile)
            }
        }
    }

    private fun navigateToFragment(destinationId: Int, selectedButton: ImageButton) {
        navController.navigate(destinationId)
        setSelectedButton(selectedButton)
    }

    private fun setSelectedButton(selectedButton: ImageButton) {
        btnHome.isSelected = false
        btnLove.isSelected = false
        btnProfile.isSelected = false
        selectedButton.isSelected = true
    }
}
