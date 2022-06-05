package com.example.paradise.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import com.example.paradise.MainActivity
import com.example.paradise.R
import com.example.paradise.databinding.FragmentProfileBinding
import com.example.paradise.ui.profile.account.Account


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        val account = view?.findViewById<LinearLayout>(R.id.account)
        val purchases = view?.findViewById<LinearLayout>(R.id.purchases)
        val settings = view?.findViewById<LinearLayout>(R.id.settings)
        val feedback = view?.findViewById<LinearLayout>(R.id.feedback)
        val info = view?.findViewById<LinearLayout>(R.id.info)
        account?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_navigation_profile_to_account2)
        }
        purchases?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_navigation_profile_to_purshares)
        }
        settings?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_navigation_profile_to_settings2)
        }
        feedback?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_navigation_profile_to_feedBack)
        }
        info?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_navigation_profile_to_info_application)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}