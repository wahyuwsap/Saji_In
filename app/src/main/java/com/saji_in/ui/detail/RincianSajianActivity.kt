package com.saji_in.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.saji_in.databinding.ActivityRincianSajianBinding
import com.saji_in.model.FoodItem
import com.saji_in.R
import com.saji_in.MainActivity
import androidx.core.content.ContextCompat


class RincianSajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRincianSajianBinding
    private lateinit var currentItem: FoodItem
    private var isLoved: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRincianSajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = MainActivity.sharedViewModelRef
        currentItem = intent.getParcelableExtra("foodItem") ?: return finish()

        // Cek apakah sudah disukai
        isLoved = viewModel.lovedItems.value?.contains(currentItem) == true
        updateLoveIcon(isLoved)

        // Tampilkan data dasar
        binding.tvTitle.text = currentItem.title
        binding.tvDescription.text = currentItem.description
        binding.ivFoodImage.setImageResource(currentItem.imageResId)
        binding.tvCookTime.text = currentItem.cookTime
        binding.tvServingSize.text = "Untuk ${currentItem.servingSize}"

        // Daftar bahan
        currentItem.ingredients.forEach { (bahan, ukuran) ->
            val view = layoutInflater.inflate(R.layout.item_bahan, binding.ingredientsList, false)
            view.findViewById<TextView>(R.id.namaBahan).text = bahan
            view.findViewById<TextView>(R.id.takaran).text = ukuran
            binding.ingredientsList.addView(view)
        }

        // Daftar langkah
        currentItem.steps.forEachIndexed { index, langkah ->
            val view = layoutInflater.inflate(R.layout.item_langkah, binding.stepsList, false)
            view.findViewById<TextView>(R.id.tvStepTitle).text = "Step ${index + 1}"
            view.findViewById<TextView>(R.id.tvStepContent).text = langkah
            binding.stepsList.addView(view)
        }

        // Tombol kembali utama
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Tombol love toggle
        binding.ivLove.setOnClickListener {
            viewModel.toggleLove(currentItem)
            isLoved = !isLoved
            updateLoveIcon(isLoved)
        }

        // SEMUA AWALNYA HIDE
        binding.scrollContainer.slideDown()
        binding.ingredientsList.visibility = View.GONE
        binding.stepsList.visibility = View.GONE

        // Klik tombol ivdetail untuk tampilkan bahan saja
        binding.ivdetail.setOnClickListener {
            binding.scrollContainer.slideUp()
            binding.ingredientsList.visibility = View.VISIBLE
            binding.stepsList.visibility = View.GONE
            binding.titlebahan.text = "Bahan yang diperlukan"
            binding.tvTotalBahan.text = "${currentItem.ingredients.size} bahan"
            binding.tvTotalBahan.visibility = View.VISIBLE
            updateButtonState(true)

        }

        // Tombol langkah
        binding.btnMemasak.setOnClickListener {
            binding.ingredientsList.visibility = View.GONE
            binding.stepsList.visibility = View.VISIBLE
            binding.titlebahan.text = "Jumlah takaran saji"
            binding.tvTotalBahan.text = "${currentItem.steps.size} langkah"
            binding.tvTotalBahan.visibility = View.VISIBLE
            updateButtonState(false)

        }

        // Tombol kembali ke bahan
        binding.btnBahannya.setOnClickListener {
            binding.ingredientsList.visibility = View.VISIBLE
            binding.stepsList.visibility = View.GONE
            binding.titlebahan.text = "Bahan yang diperlukan"
            binding.tvTotalBahan.text = "${currentItem.ingredients.size} bahan"
            binding.tvTotalBahan.visibility = View.VISIBLE
            updateButtonState(true)

        }

        // Tombol back dalam scroll
        binding.btnBack2.setOnClickListener {
            binding.scrollContainer.slideDown()

        }
    }
    fun View.slideUp(duration: Long = 300) {
        visibility = View.VISIBLE
        translationY = height.toFloat()
        alpha = 0f
        animate()
            .translationY(0f)
            .alpha(1f)
            .setDuration(duration)
            .start()
    }

    fun View.slideDown(duration: Long = 300, onEnd: () -> Unit = {}) {
        animate()
            .translationY(height.toFloat())
            .alpha(0f)
            .setDuration(duration)
            .withEndAction {
                visibility = View.GONE
                onEnd()
            }
            .start()
    }


    private fun updateLoveIcon(isLoved: Boolean) {
        val icon = if (isLoved) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
        binding.ivLove.setImageResource(icon)
    }

    private fun updateButtonState(isBahan: Boolean) {
        val colorPrimary = ContextCompat.getColor(this, R.color.teal_custom)
        val colorWhite = ContextCompat.getColor(this, R.color.white)

        if (isBahan) {
            binding.btnBahannya.setBackgroundColor(colorPrimary)
            binding.btnBahannya.setTextColor(colorWhite)
            binding.btnMemasak.setBackgroundColor(colorWhite)
            binding.btnMemasak.setTextColor(colorPrimary)
        } else {
            binding.btnBahannya.setBackgroundColor(colorWhite)
            binding.btnBahannya.setTextColor(colorPrimary)
            binding.btnMemasak.setBackgroundColor(colorPrimary)
            binding.btnMemasak.setTextColor(colorWhite)
        }
    }

}
