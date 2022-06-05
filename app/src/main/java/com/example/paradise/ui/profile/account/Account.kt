package com.example.paradise.ui.profile.account

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.example.paradise.MainActivity
import com.example.paradise.R
import com.example.paradise.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Account : Fragment() {

    companion object {
        fun newInstance() = Account()
    }

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.account_fragment, container, false)
    }
    override fun onStart() {
        super.onStart()
        try {
            val back = view?.findViewById<ImageView>(R.id.feed_back)
            back?.setOnClickListener{ view : View ->
                view.findNavController().popBackStack()
            }
        }
        catch (e: Exception){
            Log.d("TAG", e.toString())
        }
        val accountInfo = view?.findViewById<TextView>(R.id.info_account)
        val adres = view?.findViewById<TextView>(R.id.adres)
        val password = view?.findViewById<TextView>(R.id.password)
        accountInfo?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_account2_to_account_info)
        }
        adres?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_account2_to_adress)
        }
        password?.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_account2_to_password2)
        }
    }
}