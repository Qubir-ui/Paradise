package com.example.paradise.ui.profile.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.paradise.R


class Settings : Fragment() {

    companion object {
        fun newInstance() = Settings()
    }

    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings_fragment, container, false)
    }
    override fun onStart() {
        super.onStart()
        try {
            val back = view?.findViewById<ImageView>(R.id.settings_back)
            back?.setOnClickListener{ view : View ->
                view.findNavController().popBackStack()
            }
        }
        catch (e: Exception){
            Log.d("TAG", e.toString())
        }
    }

}