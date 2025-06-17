package com.saji_in.ui.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.auth.LoginActivity
import com.saji_in.databinding.ActivityGantiPasswordBinding
import com.saji_in.db.UserDatabaseHelper

class GantiPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGantiPasswordBinding
    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGantiPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val email = sharedPref.getString("email", null)

        binding.btnSimpan.setOnClickListener {
            val oldPasswordInput = binding.etPasswordLama.text.toString().trim()
            val newPassword = binding.etPasswordBaru.text.toString().trim()

            if (email.isNullOrEmpty()) {
                Toast.makeText(this, "Email tidak ditemukan!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = dbHelper.getUserByEmail(email)

            if (oldPasswordInput.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else if (user == null || user.password != oldPasswordInput) {
                Toast.makeText(this, "Password lama salah", Toast.LENGTH_SHORT).show()
            } else {
                val updatedUser = user.copy(password = newPassword)
                val result = dbHelper.updateUser(updatedUser)

                if (result > 0) {
                    // Optional: Simpan password baru ke SharedPreferences
                    sharedPref.edit().putString("password", newPassword).apply()

                    Toast.makeText(this, "Password berhasil diubah", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Gagal mengubah password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
