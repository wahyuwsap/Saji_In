package com.saji_in.ui.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
                finish()
            }
        }
    }
}
