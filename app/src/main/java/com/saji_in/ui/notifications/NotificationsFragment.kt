package com.saji_in.ui.notifications

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.saji_in.auth.LoginActivity
import com.saji_in.databinding.FragmentNotificationsBinding
import com.saji_in.db.UserDatabaseHelper
import com.saji_in.model.UserModel
import com.saji_in.ui.settings.*

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbHelper: UserDatabaseHelper
    private var userId: Int = -1
    private var currentUser: UserModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        dbHelper = UserDatabaseHelper(requireContext())

        // Ambil user ID dari activity
        userId = requireActivity().intent.getIntExtra("user_id", -1)

        if (userId == -1) {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        } else {
            loadUserData()
        }

        binding.logOut.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        binding.tos.setOnClickListener {
            startActivity(Intent(requireContext(), TermsOfServiceActivity::class.java))
        }

        binding.privacyPolicy.setOnClickListener {
            startActivity(Intent(requireContext(), PrivacyPolicyActivity::class.java))
        }

        binding.gantiPassword.setOnClickListener {
            val intent = Intent(requireContext(), GantiPasswordActivity::class.java)
            intent.putExtra("user_id", userId)
            startActivity(intent)
        }

        binding.editProfile.setOnClickListener {
            val intent = Intent(requireContext(), EditProfileActivity::class.java)
            intent.putExtra("user_id", userId)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        loadUserData()
    }

    private fun loadUserData() {
        currentUser = dbHelper.getUserById(userId)

        currentUser?.let { user ->
            binding.tvGreeting.text = user.username
            if (!user.profileImageUri.isNullOrEmpty()) {
                Glide.with(this)
                    .load(Uri.parse(user.profileImageUri))
                    .into(binding.ivProfile)
            } else {
                binding.ivProfile.setImageResource(com.saji_in.R.drawable.ic_person)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
