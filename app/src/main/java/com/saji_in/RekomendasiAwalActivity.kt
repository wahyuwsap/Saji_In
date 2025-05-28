package com.saji_in

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.saji_in.auth.LoginActivity

class RekomendasiAwalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rekomendasi_awal)

        val nextButton: TextView = findViewById(R.id.nextButton)
        val skipButton: TextView = findViewById(R.id.skip)

        nextButton.setOnClickListener {
            val intent = Intent(this, RekomendasiResepActivity::class.java)
            startActivity(intent)
        }

        skipButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Optional: tutup activity ini agar tidak bisa kembali ke sini
        }
    }
}
