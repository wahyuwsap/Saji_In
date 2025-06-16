package com.saji_in.ui.home

import android.content.Context
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saji_in.R
import com.saji_in.adapter.RecommendationAdapter
import com.saji_in.databinding.FragmentHomeBinding
import com.saji_in.model.FoodItem
import com.saji_in.model.SharedViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var adapter: RecommendationAdapter

    private val foodList = listOf(
        FoodItem(
            title = "Popcorn Caramel",
            description = "Manis legit, crunchy terus!",
            imageResId = R.drawable.popcorn,
            cookTime = "15 Mins",
            ingredients = listOf("Jagung", "Gula", "Mentega")
        ),
        FoodItem(
            title = "Kue Cubit Topping",
            description = "Lumer, manis, seru banget",
            imageResId = R.drawable.kue_cubit,
            cookTime = "15 Mins",
            ingredients = listOf("Tepung", "Telur", "Coklat", "Meses")
        ),
        FoodItem(
            title = "Spaghetti",
            description = "Gak usah fancy, cukup spaghetti carbonara buat manjain lidah",
            imageResId = R.drawable.spageti,
            cookTime = "15 Mins",
            ingredients = listOf("Kulit risoles", "Ayam", "Wortel", "Susu")
        ),
        FoodItem(
            title = "Chicken Katsu",
            description = "Gak perlu ke Jepang, cukup chicken katsu di piring kamu!",
            imageResId = R.drawable.chicken_katsu,
            cookTime = "20 Mins",
            ingredients = listOf("Tepung", "Keju", "Cabai bubuk")
        ),
        FoodItem(
            title = "Risoles Ayam",
            description = "Renyaah, gurih, isi melimpah!",
            imageResId = R.drawable.risoles,
            cookTime = "45 Mins",
            ingredients = listOf("Kulit risoles", "Ayam", "Wortel", "Susu")
        ),
        FoodItem(
            title = "Keripik Keju Pedas",
            description = "Sarapan spesial, tapi tetap murah",
            imageResId = R.drawable.keripik_keju,
            cookTime = "10 Mins",
            ingredients = listOf("Tepung", "Keju", "Cabai bubuk")
        ),
        FoodItem(
            title = "Tumis Kangkung",
            description = " kangen masakan rumahan, tumis kangkung bisa obatin rindu",
            imageResId = R.drawable.tumis_kangkung,
            cookTime = "10 Mins",
            ingredients = listOf("Kulit risoles", "Ayam", "Wortel", "Susu")
        ),
        FoodItem(
            title = "Nasi Kuning",
            description = " sarapan spesial tapi tetep ramah di kantong",
            imageResId = R.drawable.nasi_kuning,
            cookTime = "45 Mins",
            ingredients = listOf("Tepung", "Keju", "Cabai bubuk")
        ),
        FoodItem(
            title = "Nasi Goreng",
            description = "Cocok buat kamu yang pengen kenyang tapi ga ribet",
            imageResId = R.drawable.nasi_goreng,
            cookTime = "15 Mins",
            ingredients = listOf("Kulit risoles", "Ayam", "Wortel", "Susu")
        ),
        FoodItem(
            title = "Telur Dadar",
            description = "Buat kamu yang suka hemat tapi tetep pengen nikmat",
            imageResId = R.drawable.telur_dadar,
            cookTime = "10 Mins",
            ingredients = listOf("Tepung", "Keju", "Cabai bubuk")
        )
    )

    private var filteredList = foodList.toMutableList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false) // ✅ Inisialisasi dulu baru dipakai
        val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val uriString = sharedPref.getString("profile_image_uri", null)

        if (uriString != null) {
            val uri = Uri.parse(uriString)
            binding.ivProfile.setImageURI(uri)
        } else {
            binding.ivProfile.setImageResource(R.drawable.ic_person)
        }

        setupRecyclerView()
        setupSearch()

        return binding.root
    }


    private fun setupRecyclerView() {
        adapter = RecommendationAdapter(filteredList, sharedViewModel, viewLifecycleOwner)

        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvRekomendasi.layoutManager = gridLayoutManager
        binding.rvRekomendasi.adapter = adapter

        val spacingInPixels = try {
            resources.getDimensionPixelSize(R.dimen.grid_spacing)
        } catch (e: Exception) {
            resources.getDimensionPixelSize(R.dimen.activity_horizontal_margin) / 2
        }

        binding.rvRekomendasi.addItemDecoration(
            GridSpacingItemDecoration(2, spacingInPixels, true)
        )
    }

    private fun setupSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().lowercase()
                filteredList.clear()
                filteredList.addAll(foodList.filter {
                    it.title.lowercase().contains(query) || it.description.lowercase().contains(query)
                })
                adapter.notifyDataSetChanged()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private class GridSpacingItemDecoration(
        private val spanCount: Int,
        private val spacing: Int,
        private val includeEdge: Boolean
    ) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view)
            val column = position % spanCount

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount
                outRect.right = (column + 1) * spacing / spanCount

                if (position < spanCount) {
                    outRect.top = spacing
                }
                outRect.bottom = spacing
            } else {
                outRect.left = column * spacing / spanCount
                outRect.right = spacing - (column + 1) * spacing / spanCount
                if (position >= spanCount) {
                    outRect.top = spacing
                }
            }
        }
    }
}