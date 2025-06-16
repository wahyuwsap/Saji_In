package com.saji_in.ui.dashboard

import android.os.Bundle
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
    private val sharedViewModel: SharedViewModel by activityViewModels()

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
        // Tombol back
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        // Tombol search
        binding.ivSearch.setOnClickListener {
            // Jika kamu ingin nanti tampil popup pencarian, bisa ditambahkan logika di sini
            // Misalnya buka dialog, atau navigasi ke fragment pencarian love
        }
    }

    private fun setupRecyclerView() {
        adapter = RecommendationAdapter(lovedItems, sharedViewModel, viewLifecycleOwner)
        binding.rvLovedItems.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvLovedItems.adapter = adapter
    }

    private fun observeLovedItems() {
        sharedViewModel.lovedItems.observe(viewLifecycleOwner) { items ->
            lovedItems.clear()
            lovedItems.addAll(items)
            adapter.notifyDataSetChanged()

            if (lovedItems.isEmpty()) {
                binding.emptyStateLayout.visibility = View.VISIBLE
                binding.rvLovedItems.visibility = View.GONE
            } else {
                binding.emptyStateLayout.visibility = View.GONE
                binding.rvLovedItems.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
