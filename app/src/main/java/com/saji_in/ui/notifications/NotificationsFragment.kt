package com.saji_in.ui.notifications

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saji_in.databinding.FragmentNotificationsBinding
import com.saji_in.R
import com.saji_in.auth.LoginActivity
import com.saji_in.ui.settings.*

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        // Ambil SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val namaLengkap = sharedPref.getString("username", "")
        val uriString = sharedPref.getString("profile_image_uri", null)

        if (uriString != null) {
            val uri = Uri.parse(uriString)
            binding.ivProfile.setImageURI(uri)
        } else {
            binding.ivProfile.setImageResource(R.drawable.ic_person)
        }

        binding.tvGreeting.text = namaLengkap

        // Logout
        binding.logOut.setOnClickListener {
            sharedPref.edit()
                .putBoolean("isLoggedIn", false) // ❗ hanya ubah flag login
                .apply()

            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


        // Term of Services
        binding.tos.setOnClickListener {
            startActivity(Intent(requireContext(), TermsOfServiceActivity::class.java))
        }

        // Privacy Policy
        binding.privacyPolicy.setOnClickListener {
            startActivity(Intent(requireContext(), PrivacyPolicyActivity::class.java))
        }

        // Ganti Password
        binding.gantiPassword.setOnClickListener {
            startActivity(Intent(requireContext(), GantiPasswordActivity::class.java))
        }

        // Edit Profile
        binding.editProfile.setOnClickListener {
            startActivity(Intent(requireContext(), EditProfileActivity::class.java))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
