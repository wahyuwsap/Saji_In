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

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferences: SharedPreferences
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Tombol Login
        binding.btnLogin.setOnClickListener {
            val emailInput = binding.edtEmail.text.toString().trim()         // Ganti username ke email
            val passwordInput = binding.edtPassword.text.toString().trim()

            val savedEmail = preferences.getString("email", null)            // Ambil data email dari SharedPreferences
            val savedPassword = preferences.getString("password", null)

            if (emailInput == savedEmail && passwordInput == savedPassword) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Tombol Sign Up
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.imgTogglePassword.setOnClickListener {
            if (isPasswordVisible) {
                binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.imgTogglePassword.setImageResource(R.drawable.ic_eye) // ikon mata default
                isPasswordVisible = false
            } else {
                binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.imgTogglePassword.setImageResource(R.drawable.ic_eye) // ikon mata terbuka
                isPasswordVisible = true
            }
            binding.edtPassword.setSelection(binding.edtPassword.text.length)
        }
    }
}
