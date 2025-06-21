package com.saji_in.ui.settings

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.saji_in.databinding.ActivityEditProfileBinding
import com.saji_in.db.UserDatabaseHelper
import com.saji_in.model.UserModel

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var dbHelper: UserDatabaseHelper
    private var selectedImageUri: Uri? = null
    private var currentUser: UserModel? = null
    private var userId: Int = -1
    private val REQUEST_CODE_STORAGE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = UserDatabaseHelper(this)
        userId = intent.getIntExtra("user_id", -1)

        if (userId == -1) {
            Toast.makeText(this, "User ID tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        currentUser = dbHelper.getUserById(userId)

        currentUser?.let { user ->
            binding.etUsername.setText(user.username)
            binding.etEmail.setText(user.email)
            binding.etTelepon.setText(user.telepon)

            if (!user.profileImageUri.isNullOrEmpty()) {
                selectedImageUri = Uri.parse(user.profileImageUri)
                Glide.with(this)
                    .load(selectedImageUri)
                    .into(binding.ivProfile)
            }
        }

        binding.btnSimpan.setOnClickListener { updateUser() }

        binding.cameraIconContainer.setOnClickListener {
            checkStoragePermission()
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun updateUser() {
        val username = binding.etUsername.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val telepon = binding.etTelepon.text.toString().trim()
        val imageUriStr = selectedImageUri?.toString() ?: ""

        if (username.isNotEmpty() && email.isNotEmpty() && telepon.isNotEmpty()) {
            currentUser?.let { user ->
                val updatedUser = user.copy(
                    username = username,
                    email = email,
                    telepon = telepon,
                    profileImageUri = imageUriStr
                )
                val result = dbHelper.updateUser(updatedUser)
                if (result > 0) {
                    Toast.makeText(this, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkStoragePermission() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), REQUEST_CODE_STORAGE)
        } else {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(intent)
    }

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data?.data
            selectedImageUri?.let {
                Glide.with(this)
                    .load(it)
                    .into(binding.ivProfile)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_STORAGE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openGallery()
        } else {
            Toast.makeText(this, "Izin diperlukan untuk mengakses galeri", Toast.LENGTH_SHORT).show()
        }
    }
}
