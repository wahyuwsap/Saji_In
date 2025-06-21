package com.saji_in.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.databinding.ActivityRincianSajianBinding
import com.saji_in.model.FoodItem
import com.saji_in.R
import com.saji_in.MainActivity

class RincianSajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRincianSajianBinding
    private lateinit var currentItem: FoodItem
    private var isLoved: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRincianSajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = MainActivity.sharedViewModelRef

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val title = intent.getStringExtra("title") ?: ""
        val description = intent.getStringExtra("description") ?: ""
        val imageResId = intent.getIntExtra("imageResId", 0)
        val cookTime = intent.getStringExtra("cookTime") ?: ""
        val ingredientsArray = intent.getStringArrayExtra("ingredients") ?: arrayOf()
        val ingredients = ingredientsArray.toList()

        currentItem = FoodItem(title, description, imageResId, cookTime, ingredients)

        // Cek apakah sudah dilove
        isLoved = viewModel.lovedItems.value?.contains(currentItem) == true
        updateLoveIcon(isLoved)

        // Tampilkan data
        binding.tvTitle.text = title
        binding.tvDescription.text = description
        binding.ivFoodImage.setImageResource(imageResId)

        binding.ivLove.setOnClickListener {
            viewModel.toggleLove(currentItem)
            isLoved = !isLoved
            updateLoveIcon(isLoved)
        }
    }

    private fun updateLoveIcon(isLoved: Boolean) {
        val icon = if (isLoved) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
        binding.ivLove.setImageResource(icon)
    }
}
