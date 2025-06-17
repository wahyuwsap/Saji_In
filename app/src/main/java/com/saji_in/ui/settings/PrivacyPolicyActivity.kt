package com.saji_in.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.R

class PrivacyPolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy)

        supportActionBar?.title = "Kebijakan Privasi"

        // Pastikan tombol dengan id btnBack ada di layout
        findViewById<android.view.View>(R.id.btnBack)?.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
