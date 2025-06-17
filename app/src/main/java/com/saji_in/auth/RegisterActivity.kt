package com.saji_in.auth

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.R
import com.saji_in.databinding.ActivityRegisterBinding
import com.saji_in.db.UserDatabaseHelper
import com.saji_in.model.UserModel


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var isPasswordVisible = false
    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)

        binding.btnRegister.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val namaDepan = binding.edtNamaDepan.text.toString().trim()
            val namaBelakang = binding.edtNamaBelakang.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            if (username.isNotEmpty() && namaDepan.isNotEmpty() && namaBelakang.isNotEmpty()
                && email.isNotEmpty() && password.isNotEmpty()) {

                val user = UserModel(
                    id = 0,
                    username = username,
                    namaDepan = namaDepan,
                    namaBelakang = namaBelakang,
                    email = email,
                    password = password,
                    telepon = "",
                    profileImageUri = ""
                )

                val result = dbHelper.insertUser(user)

                if (result != -1L) {
                    Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Registrasi gagal!", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }


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
