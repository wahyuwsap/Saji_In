package com.saji_in.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class FoodType {
    MAKANAN, MINUMAN, JAJANAN
}

@Parcelize
data class FoodItem(
    val title: String,
    val description: String,
    val imageResId: Int,
    val cookTime: String,
    val ingredients: List<Pair<String, String>>,
    val steps: List<String>,
    val type: FoodType,
    val servingSize: String, // Contoh: "2 porsi"
    var isLoved: Boolean = false
) : Parcelable {
    val totalBahan: Int
        get() = ingredients.size

    val totalLangkah: Int
        get() = steps.size
}
