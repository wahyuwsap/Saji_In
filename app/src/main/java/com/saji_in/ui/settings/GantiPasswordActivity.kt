package com.saji_in.ui.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.saji_in.R
import com.saji_in.auth.LoginActivity
import com.saji_in.databinding.ActivityGantiPasswordBinding

class GantiPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGantiPasswordBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGantiPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        binding.btnSimpan.setOnClickListener {
            val oldPasswordInput = binding.etPasswordLama.text.toString().trim()
            val newPassword = binding.etPasswordBaru.text.toString().trim()
            val savedPassword = sharedPref.getString("password", "")

            if (oldPasswordInput.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else if (oldPasswordInput != savedPassword) {
                Toast.makeText(this, "Password lama salah", Toast.LENGTH_SHORT).show()
            } else {
                sharedPref.edit().putString("password", newPassword).apply()
                Toast.makeText(this, "Password berhasil diubah", Toast.LENGTH_SHORT).show()

                // Arahkan ke LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }

        }
        findViewById<android.view.View>(R.id.btnBack)?.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
