package com.saji_in.auth

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.MainActivity
import com.saji_in.R
import com.saji_in.databinding.ActivityLoginBinding
import com.saji_in.db.UserDatabaseHelper
import com.saji_in.model.UserModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var dbHelper: UserDatabaseHelper
    private lateinit var preferences: SharedPreferences
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)
        preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Tombol Login
        binding.btnLogin.setOnClickListener {
            val emailInput = binding.edtEmail.text.toString().trim()
            val passwordInput = binding.edtPassword.text.toString().trim()

            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user: UserModel? = dbHelper.getUserByEmailAndPassword(emailInput, passwordInput)

            if (user != null) {
                // Simpan info user ke SharedPreferences jika ingin digunakan nanti
                preferences.edit()
                    .putString("username", user.username)
                    .putString("email", user.email)
                    .putString("namaDepan", user.namaDepan)
                    .putString("namaBelakang", user.namaBelakang)
                    .putString("telepon", user.telepon)
                    .putString("profileImageUri", user.profileImageUri)
                    .apply()

                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Tombol Sign Up
        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Toggle tampil/simpan password
        binding.imgTogglePassword.setOnClickListener {
            if (isPasswordVisible) {
                binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.imgTogglePassword.setImageResource(R.drawable.ic_eye)
            } else {
                binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.imgTogglePassword.setImageResource(R.drawable.ic_eyeopen)
            }
            isPasswordVisible = !isPasswordVisible
            binding.edtPassword.setSelection(binding.edtPassword.text.length)
        }
    }
}
