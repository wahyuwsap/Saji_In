package com.saji_in.model

data class FoodItem(
    val title: String,
    val description: String,
    val imageResId: Int,
    val cookTime: String,
    val ingredients: List<String>,
    var isLoved: Boolean = false
)