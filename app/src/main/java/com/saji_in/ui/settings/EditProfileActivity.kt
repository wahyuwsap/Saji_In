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
import com.saji_in.databinding.ActivityEditProfileBinding
import com.saji_in.db.UserDatabaseHelper
import com.saji_in.model.UserModel

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var dbHelper: UserDatabaseHelper
    private var selectedImageUri: Uri? = null
    private var currentUser: UserModel? = null
    private val REQUEST_CODE_STORAGE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        dbHelper = UserDatabaseHelper(this)

        // Ambil data user yang sedang login (misalnya lewat email disimpan di SharedPreferences)
        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val userEmail = sharedPref.getString("email", null)

        if (!userEmail.isNullOrEmpty()) {
            currentUser = dbHelper.getUserByEmail(userEmail)
            currentUser?.let { user ->
                binding.etUsername.setText(user.username)
                binding.etEmail.setText(user.email)
                binding.etTelepon.setText(user.telepon)

                if (!user.profileImageUri.isNullOrEmpty()) {
                    val uri = Uri.parse(user.profileImageUri)
                    binding.ivProfile.setImageURI(uri)
                    selectedImageUri = uri
                }

            }
        }



        binding.btnSimpan.setOnClickListener {
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

        binding.cameraIconContainer.setOnClickListener {
            checkStoragePermission()
        }
    }

    private fun setupToolbar() {
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
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
