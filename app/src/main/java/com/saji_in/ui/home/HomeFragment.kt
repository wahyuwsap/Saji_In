package com.saji_in.ui.home

import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var adapter: RecommendationAdapter

    private lateinit var dbHelper: UserDatabaseHelper
    private var userId: Int = -1

    private val foodList = listOf(
        FoodItem(
            title = "Popcorn Caramel",
            description = "Manis legit, crunchy terus!",
            imageResId = R.drawable.popcorn,
            cookTime = "15 Mins",
            ingredients = listOf(
                "Jagung" to "100 gram",
                "Gula" to "3 sdm",
                "Mentega" to "2 sdm"
            ),
            steps = listOf(
                "Panaskan mentega di wajan.",
                "Masukkan jagung dan tutup wajan.",
                "Tunggu hingga semua jagung meletup menjadi popcorn.",
                "Lelehkan gula hingga menjadi karamel.",
                "Campurkan popcorn dengan karamel, aduk rata."
            ),
            type = FoodType.JAJANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Kue Cubit Topping",
            description = "Lumer, manis, seru banget",
            imageResId = R.drawable.kue_cubit,
            cookTime = "15 Mins",
            ingredients = listOf(
                "Tepung" to "100 gram",
                "Telur" to "2 butir",
                "Coklat" to "50 gram",
                "Meses" to "secukupnya"
            ),
            steps = listOf(
                "Campurkan tepung, telur, dan coklat hingga rata.",
                "Tuang adonan ke cetakan kue cubit.",
                "Tambahkan meses di atas adonan.",
                "Masak dengan api kecil hingga matang.",
                "Angkat dan sajikan hangat."
            ),
            type = FoodType.MAKANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Spaghetti",
            description = "Gak usah fancy, cukup spaghetti carbonara buat manjain lidah",
            imageResId = R.drawable.spageti,
            cookTime = "15 Mins",
            ingredients = listOf(
                "Spaghetti" to "150 gram",
                "Daging asap" to "100 gram",
                "Susu" to "100 ml",
                "Keju parut" to "50 gram"
            ),
            steps = listOf(
                "Rebus spaghetti hingga matang.",
                "Tumis daging asap hingga harum.",
                "Tambahkan susu dan keju, aduk rata.",
                "Masukkan spaghetti dan aduk hingga meresap.",
                "Sajikan dengan taburan keju."
            ),
            type = FoodType.MAKANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Chicken Katsu",
            description = "Gak perlu ke Jepang, cukup chicken katsu di piring kamu!",
            imageResId = R.drawable.chicken_katsu,
            cookTime = "20 Mins",
            ingredients = listOf(
                "Dada ayam" to "200 gram",
                "Tepung roti" to "100 gram",
                "Telur" to "1 butir",
                "Minyak goreng" to "secukupnya"
            ),
            steps = listOf(
                "Iris dan pipihkan dada ayam.",
                "Balur ayam dengan tepung, telur, dan tepung roti.",
                "Panaskan minyak dan goreng ayam hingga keemasan.",
                "Tiriskan dan sajikan dengan saus."
            ),
            type = FoodType.MAKANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Risoles Ayam",
            description = "Renyaah, gurih, isi melimpah!",
            imageResId = R.drawable.risoles,
            cookTime = "45 Mins",
            ingredients = listOf(
                "Kulit risoles" to "10 lembar",
                "Ayam suwir" to "150 gram",
                "Wortel parut" to "1 buah",
                "Susu cair" to "50 ml"
            ),
            steps = listOf(
                "Tumis ayam dan wortel, tuang susu, masak hingga kering.",
                "Isi kulit risoles dengan isian ayam.",
                "Gulung dan rekatkan tepinya.",
                "Goreng hingga keemasan."
            ),
            type = FoodType.JAJANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Keripik Keju Pedas",
            description = "Sarapan spesial, tapi tetap murah",
            imageResId = R.drawable.keripik_keju,
            cookTime = "10 Mins",
            ingredients = listOf(
                "Tepung terigu" to "100 gram",
                "Keju parut" to "50 gram",
                "Cabai bubuk" to "1 sdm"
            ),
            steps = listOf(
                "Campur semua bahan hingga kalis.",
                "Gilas adonan tipis, potong sesuai selera.",
                "Goreng dalam minyak panas hingga kering.",
                "Tiriskan dan sajikan."
            ),
            type = FoodType.JAJANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Tumis Kangkung",
            description = "Kangen masakan rumahan? Tumis kangkung bisa obatin rindu!",
            imageResId = R.drawable.tumis_kangkung,
            cookTime = "10 Mins",
            ingredients = listOf(
                "Kangkung" to "1 ikat",
                "Bawang putih" to "2 siung",
                "Cabai merah" to "3 buah",
                "Minyak goreng" to "2 sdm"
            ),
            steps = listOf(
                "Iris bawang dan cabai, tumis hingga harum.",
                "Masukkan kangkung, aduk cepat.",
                "Tambahkan sedikit air dan garam.",
                "Masak hingga layu, sajikan segera."
            ),
            type = FoodType.MAKANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Nasi Kuning",
            description = "Sarapan spesial tapi tetep ramah di kantong",
            imageResId = R.drawable.nasi_kuning,
            cookTime = "45 Mins",
            ingredients = listOf(
                "Beras" to "2 gelas",
                "Santan" to "400 ml",
                "Kunyit" to "1 ruas, haluskan",
                "Daun salam" to "2 lembar"
            ),
            steps = listOf(
                "Cuci beras, masukkan ke dalam rice cooker.",
                "Tambahkan santan, kunyit, dan daun salam.",
                "Masak hingga nasi matang dan kuning merata.",
                "Sajikan dengan lauk favorit."
            ),
            type = FoodType.MAKANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Nasi Goreng",
            description = "Cocok buat kamu yang pengen kenyang tapi ga ribet",
            imageResId = R.drawable.nasi_goreng,
            cookTime = "15 Mins",
            ingredients = listOf(
                "Nasi putih" to "1 piring",
                "Telur" to "1 butir",
                "Kecap manis" to "1 sdm",
                "Bumbu halus" to "secukupnya"
            ),
            steps = listOf(
                "Tumis bumbu halus hingga harum.",
                "Masukkan telur, orak-arik.",
                "Tambahkan nasi putih dan kecap.",
                "Aduk rata dan sajikan hangat."
            ),
            type = FoodType.MAKANAN,
            servingSize = "2 porsi"
        ),
        FoodItem(
            title = "Telur Dadar",
            description = "Buat kamu yang suka hemat tapi tetep pengen nikmat",
            imageResId = R.drawable.telur_dadar,
            cookTime = "10 Mins",
            ingredients = listOf(
                "Telur" to "2 butir",
                "Daun bawang" to "1 batang",
                "Garam" to "secukupnya",
                "Minyak goreng" to "1 sdm"
            ),
            steps = listOf(
                "Kocok telur dengan garam dan daun bawang.",
                "Panaskan minyak di wajan.",
                "Tuang adonan telur, ratakan.",
                "Masak kedua sisi hingga matang."
            ),
            type = FoodType.MAKANAN,
            servingSize = "2 porsi"
        )
    )


    private var filteredList = foodList.toMutableList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        dbHelper = UserDatabaseHelper(requireContext())

        // Ambil user ID dari activity
        userId = requireActivity().intent.getIntExtra("user_id", -1)

        if (userId != -1) {
            loadUserProfileImage()
        }

        setupRecyclerView()
        setupSearch()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        loadUserProfileImage()
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
