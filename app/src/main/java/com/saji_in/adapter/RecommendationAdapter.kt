package com.saji_in.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.saji_in.R
import com.saji_in.databinding.ItemRekomendasiBinding
import com.saji_in.model.FoodItem
import com.saji_in.model.SharedViewModel
import com.saji_in.ui.detail.RincianSajianActivity

class RecommendationAdapter(
    private val list: MutableList<FoodItem>,
    private val sharedViewModel: SharedViewModel,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<RecommendationAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRekomendasiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var currentItem: FoodItem? = null

        init {
            binding.ivLove.setOnClickListener {
                currentItem?.let { item ->
                    sharedViewModel.toggleLove(item)
                }
            }

            binding.root.setOnClickListener {
                currentItem?.let { item ->
                    val context = it.context
                    val intent = Intent(context, RincianSajianActivity::class.java).apply {
                        putExtra("foodItem", item)
                    }
                    context.startActivity(intent)
                }
            }

            sharedViewModel.lovedItems.observe(lifecycleOwner) { lovedList ->
                currentItem?.let { item ->
                    updateLoveButton(lovedList.contains(item))
                }
            }
        }

        fun bind(item: FoodItem) {
            currentItem = item
            binding.tvTitle.text = item.title
            binding.tvDesc.text = item.description
            binding.tvCookTime.text = item.cookTime
            binding.ivFood.setImageResource(item.imageResId)

            val isLoved = sharedViewModel.lovedItems.value?.contains(item) == true
            updateLoveButton(isLoved)
        }

        private fun updateLoveButton(isLoved: Boolean) {
            binding.ivLove.setImageResource(
                if (isLoved) R.drawable.ic_favorite_filled
                else R.drawable.ic_favorite_border
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRekomendasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateData(newList: List<FoodItem>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}
