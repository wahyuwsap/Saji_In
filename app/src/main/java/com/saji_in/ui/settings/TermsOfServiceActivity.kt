package com.saji_in.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.R

class TermsOfServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_of_service)

        supportActionBar?.title = "jangka waktu layanan"

        // Pastikan tombol dengan id btnBack ada di layout
        findViewById<android.view.View>(R.id.btnBack)?.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

