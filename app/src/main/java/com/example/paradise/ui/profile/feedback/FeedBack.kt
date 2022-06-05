package com.example.paradise.ui.profile.feedback

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.paradise.R
import java.lang.Exception

class FeedBack : Fragment() {

    companion object {
        fun newInstance() = FeedBack()
    }

    private lateinit var viewModel: FeedBackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feed_back_fragment, container, false)
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
        val send = view?.findViewById<Button>(R.id.send_feedback)
        val messageFeedback = view?.findViewById<EditText>(R.id.message_feedback)
        send?.setOnClickListener {
            messageFeedback?.text?.clear()
            Toast.makeText(context, "Спасибо за отзыв!", Toast.LENGTH_SHORT).show()
        }
    }
}