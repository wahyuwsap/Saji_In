package com.saji_in.ui.settings

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.auth.LoginActivity
import com.saji_in.databinding.ActivityGantiPasswordBinding
import com.saji_in.db.UserDatabaseHelper
import com.saji_in.model.UserModel

class GantiPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGantiPasswordBinding
    private lateinit var dbHelper: UserDatabaseHelper
    private var currentUser: UserModel? = null
    private var userId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGantiPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)

        userId = intent.getIntExtra("user_id", -1)

        if (userId != -1) {
            currentUser = dbHelper.getUserById(userId)
            if (currentUser == null) {
                Toast.makeText(this, "Pengguna tidak ditemukan", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this, "User ID tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnSimpan.setOnClickListener {
            val oldPasswordInput = binding.etPasswordLama.text.toString().trim()
            val newPassword = binding.etPasswordBaru.text.toString().trim()

            if (oldPasswordInput.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            currentUser?.let { user ->
                if (user.password != oldPasswordInput) {
                    Toast.makeText(this, "Password lama salah", Toast.LENGTH_SHORT).show()
                } else {
                    val updatedUser = user.copy(password = newPassword)
                    val result = dbHelper.updateUser(updatedUser)
                    if (result > 0) {
                        Toast.makeText(this, "Password berhasil diubah", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Gagal mengubah password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
