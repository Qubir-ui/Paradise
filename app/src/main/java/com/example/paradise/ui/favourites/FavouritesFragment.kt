package com.example.paradise.ui.favourites

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.example.paradise.R
import com.example.paradise.databinding.FragmentFavouritesBinding


class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavouritesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var groupName: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onStart() {
        super.onStart()
        val add = view?.findViewById<ImageView>(R.id.add_favourites)
        add?.setOnClickListener {
            showDialog()
        }
    }
    private fun showDialog() {
        val dialogView = layoutInflater.inflate(R.layout.favourites_dialog, null)
        val customDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .show()
        groupName = dialogView.findViewById(R.id.groupNameFavourites)
        val dialogCreate = dialogView.findViewById<Button>(R.id.dialog_create)
        val dialogDismiss = dialogView.findViewById<Button>(R.id.dialog_dismiss)
        dialogCreate.setOnClickListener {
            if(groupName.text.isNotEmpty()){
                createGroup(groupName.text.toString())
                customDialog.dismiss()
            }
            else{
                Toast.makeText(context, "Введите название", Toast.LENGTH_SHORT).show()
            }
        }
        dialogDismiss.setOnClickListener {
            customDialog.dismiss()
        }
    }
    private fun createGroup(text: String){
        val textView = TextView(context)
        val linearLayout = binding.linearLayout
        val layoutParams = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        layoutParams.gravity = Gravity.LEFT
        layoutParams.setMargins(0, 200, 0, 0) // (left, top, right, bottom)
        textView.layoutParams = layoutParams
        textView.text = text
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        textView.setTextColor(Color.BLACK)
        linearLayout.addView(textView)
    }
}