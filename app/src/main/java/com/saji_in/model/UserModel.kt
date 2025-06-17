package com.saji_in.model

data class UserModel(
    val id: Int = 0,
    val username: String,
    val namaDepan: String,
    val namaBelakang: String,
    val email: String,
    val password: String,
    val telepon: String,
    val profileImageUri: String? = null
)
