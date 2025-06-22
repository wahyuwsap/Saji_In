package com.saji_in.ui.home

import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saji_in.R
import com.saji_in.adapter.RecommendationAdapter
import com.saji_in.databinding.FragmentHomeBinding
import com.saji_in.db.UserDatabaseHelper
import com.saji_in.model.FoodItem
import com.saji_in.model.FoodType
import com.saji_in.model.SharedViewModel
import com.saji_in.data.foodList

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var adapter: RecommendationAdapter

    private lateinit var dbHelper: UserDatabaseHelper
    private var userId: Int = -1

    private var filteredList = foodList.toMutableList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        dbHelper = UserDatabaseHelper(requireContext())
        userId = requireActivity().intent.getIntExtra("user_id", -1)

        if (userId != -1) {
            loadUserProfileImage()
        }

        setupRecyclerView()
        setupSearch()
        setupCategoryButtons()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        loadUserProfileImage()
    }

    private fun setupCategoryButtons() {
        val navController = findNavController()

        binding.llMakanan.setOnClickListener {
            sharedViewModel.setSelectedCategory(FoodType.MAKANAN)
            navController.navigate(R.id.action_navigation_home_to_kategoriFragment)

        }

        binding.llJajanan.setOnClickListener {
            sharedViewModel.setSelectedCategory(FoodType.JAJANAN)
            navController.navigate(R.id.action_navigation_home_to_kategoriFragment)

        }

        binding.llMinuman.setOnClickListener {
            sharedViewModel.setSelectedCategory(FoodType.MINUMAN)
            navController.navigate(R.id.action_navigation_home_to_kategoriFragment)

        }
    }

    private fun loadUserProfileImage() {
        val user = dbHelper.getUserById(userId)
        if (user != null && !user.profileImageUri.isNullOrEmpty()) {
            Glide.with(this)
                .load(Uri.parse(user.profileImageUri))
                .placeholder(R.drawable.ic_person)
                .into(binding.ivProfile)
        } else {
            binding.ivProfile.setImageResource(R.drawable.ic_person)
        }
    }

    private fun setupRecyclerView() {
        adapter = RecommendationAdapter(filteredList, sharedViewModel, viewLifecycleOwner)
        binding.rvRekomendasi.layoutManager = GridLayoutManager(requireContext(), 2)
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
                updateEmptyStateLayout()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun updateEmptyStateLayout() {
        if (filteredList.isEmpty()) {
            binding.emptyStateLayout.visibility = View.VISIBLE
            binding.rvRekomendasi.visibility = View.GONE
        } else {
            binding.emptyStateLayout.visibility = View.GONE
            binding.rvRekomendasi.visibility = View.VISIBLE
        }
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
