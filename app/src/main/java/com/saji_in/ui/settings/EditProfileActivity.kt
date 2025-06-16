package com.saji_in.ui.settings

import android.Manifest
import android.app.Activity
import android.content.Context
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
import com.saji_in.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private val REQUEST_CODE_STORAGE = 100
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load data dari SharedPreferences (opsional)
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        binding.etUsername.setText(sharedPref.getString("username", ""))
        binding.etEmail.setText(sharedPref.getString("email", ""))
        binding.etTelepon.setText(sharedPref.getString("telepon", ""))

        // Aksi simpan data
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

                // Simpan URI foto profil jika ada
                if (selectedImageUri != null) {
                    sharedPref.edit()
                        .putString("profile_image_uri", selectedImageUri.toString())
                        .apply()
                }

                Toast.makeText(this, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show()
            }
        }


        // Aksi klik ikon kamera
        binding.cameraIconContainer.setOnClickListener {
            checkStoragePermission()
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
            val data = result.data
            selectedImageUri = data?.data
            binding.ivProfile.setImageURI(selectedImageUri)
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
