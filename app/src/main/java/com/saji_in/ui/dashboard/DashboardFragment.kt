package com.saji_in.ui.dashboard

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
import com.saji_in.databinding.FragmentDashboardBinding
import com.saji_in.model.FoodItem
import com.saji_in.model.SharedViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RecommendationAdapter
    private val lovedItems = mutableListOf<FoodItem>()
    private var allLovedItems: List<FoodItem> = listOf()

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var isSearchVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        setupToolbar()
        setupRecyclerView()
        observeLovedItems()

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
        adapter = RecommendationAdapter(lovedItems, sharedViewModel, viewLifecycleOwner)
        binding.rvLovedItems.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvLovedItems.adapter = adapter
    }

    private fun observeLovedItems() {
        sharedViewModel.lovedItems.observe(viewLifecycleOwner) { items ->
            allLovedItems = items.toList()
            filterList(binding.etSearch.text.toString()) // Filter saat load ulang
        }
    }

    private fun filterList(query: String) {
        val filtered = if (query.isEmpty()) {
            allLovedItems
        } else {
            allLovedItems.filter {
                it.title.contains(query, ignoreCase = true)||it.title.contains(query, true) || it.description.contains(query, true)

            }
        }

        lovedItems.clear()
        lovedItems.addAll(filtered)
        adapter.notifyDataSetChanged()

        if (lovedItems.isEmpty()) {
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
