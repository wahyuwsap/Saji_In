
package com.saji_in.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.databinding.ActivityRincianSajianBinding

class RincianSajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRincianSajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRincianSajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageResId = intent.getIntExtra("imageResId", 0)
        val ingredientsArray = intent.getStringArrayExtra("ingredients") ?: arrayOf()
        val ingredients = ingredientsArray.joinToString(separator = "\n")

        binding.tvTitle.text = title
        binding.tvDescription.text = description
        binding.tvIngredients.text = ingredients
        binding.ivFoodImage.setImageResource(imageResId) // kalau pakai resource biasa
    }
}

