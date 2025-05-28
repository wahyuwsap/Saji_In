package com.saji_in.auth

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import android.text.InputType
import com.saji_in.R
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.databinding.ActivityRegisterBinding
import com.saji_in.auth.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var preferences: SharedPreferences
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        binding.btnRegister.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val namaDepan = binding.edtNamaDepan.text.toString().trim()
            val namaBelakang = binding.edtNamaBelakang.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            if (username.isNotEmpty() && namaDepan.isNotEmpty() && namaBelakang.isNotEmpty()
                && email.isNotEmpty() && password.isNotEmpty()) {

                val editor = preferences.edit()
                editor.putString("username", username)
                editor.putString("namaDepan", namaDepan)
                editor.putString("namaBelakang", namaBelakang)
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgTogglePassword.setOnClickListener {
            if (isPasswordVisible) {
                binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.imgTogglePassword.setImageResource(R.drawable.ic_eye) // ikon mata default
                isPasswordVisible = false
            } else {
                binding.edtPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.imgTogglePassword.setImageResource(R.drawable.ic_eyeopen) // ikon mata terbuka
                isPasswordVisible = true
            }
            binding.edtPassword.setSelection(binding.edtPassword.text.length)
        }
    }
}
