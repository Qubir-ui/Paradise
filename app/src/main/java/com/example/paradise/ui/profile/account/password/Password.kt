package com.example.paradise.ui.profile.account.password

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.paradise.R
import java.lang.Exception

class Password : Fragment() {

    companion object {
        fun newInstance() = Password()
    }

    private lateinit var viewModel: PasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.password_fragment, container, false)
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
    }

}