package com.saji_in.ui.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Set data yang lama ke EditText
        binding.etUsername.setText(sharedPref.getString("username", ""))
        binding.etEmail.setText(sharedPref.getString("email", ""))
        binding.etTelepon.setText(sharedPref.getString("telepon", ""))

        binding.btnSimpan.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val telepon = binding.etTelepon.text.toString().trim()

            if (username.isNotEmpty() && email.isNotEmpty() && telepon.isNotEmpty()) {
                sharedPref.edit()
                    .putString("username", username)
                    .putString("email", email)
                    .putString("telepon", telepon)
                    .apply()

                Toast.makeText(this, "Profil berhasil diperbarui", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
