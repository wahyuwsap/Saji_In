package com.saji_in.ui.kategori

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.saji_in.adapter.RecommendationAdapter
import com.saji_in.databinding.FragmentKategoriBinding
import com.saji_in.model.FoodItem
import com.saji_in.model.FoodType
import com.saji_in.model.SharedViewModel
import com.saji_in.data.foodList

class KategoriFragment : Fragment() {

    private var _binding: FragmentKategoriBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RecommendationAdapter
    private val displayedItems = mutableListOf<FoodItem>()
    private var allCategoryItems: List<FoodItem> = listOf()

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var isSearchVisible = false
    private var selectedCategory: FoodType? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKategoriBinding.inflate(inflater, container, false)

        selectedCategory = sharedViewModel.selectedCategory.value

        setupToolbar()
        setupRecyclerView()
        loadCategoryItems()

        return binding.root
    }

    private fun setupToolbar() {
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.ivSearch.setOnClickListener {
            isSearchVisible = !isSearchVisible
            binding.etSearch.visibility = if (isSearchVisible) View.VISIBLE else View.GONE

            if (!isSearchVisible) {
                binding.etSearch.text.clear()
                filterList("")
            }
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterList(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun setupRecyclerView() {
        adapter = RecommendationAdapter(displayedItems, sharedViewModel, viewLifecycleOwner)
        binding.rvLovedItems.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvLovedItems.adapter = adapter
    }

    private fun loadCategoryItems() {
        selectedCategory?.let { category ->
            allCategoryItems = foodList.filter { it.type == category }
            binding.titleKategori.text = category.name.lowercase().replaceFirstChar { it.uppercase() }
            filterList(binding.etSearch.text.toString())
        }
    }

    private fun filterList(query: String) {
        val filtered = if (query.isEmpty()) {
            allCategoryItems
        } else {
            allCategoryItems.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.description.contains(query, ignoreCase = true)
            }
        }

        displayedItems.clear()
        displayedItems.addAll(filtered)
        adapter.notifyDataSetChanged()

        if (displayedItems.isEmpty()) {
            binding.emptyStateLayout.visibility = View.VISIBLE
            binding.rvLovedItems.visibility = View.GONE
        } else {
            binding.emptyStateLayout.visibility = View.GONE
            binding.rvLovedItems.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
