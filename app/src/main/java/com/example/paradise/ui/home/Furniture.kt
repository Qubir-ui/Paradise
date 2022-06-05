package com.example.paradise.ui.home

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.paradise.DatabaseHelper
import com.example.paradise.LoadImage
import com.example.paradise.R
import java.io.IOException
import java.sql.SQLException


class Furniture : Fragment() {

    companion object {
        fun newInstance() = Furniture()
    }
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null
    lateinit var loadImage: LoadImage
    private lateinit var viewModel: FurnitureViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.furniture_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FurnitureViewModel::class.java)
        // TODO: Use the ViewModel
        mDBHelper = DatabaseHelper(requireContext())
    }

    override fun onStart() {
        super.onStart()
        val furniture_name = arguments?.getString("furniture_name")
        val furniture_url = arguments?.getString("furniture_url")
        val furniture_image = view?.findViewById<ImageView>(R.id.furniture_image)
        loadImage = LoadImage()
        dataBaseConnection()
        loadFurnitureName(furniture_name!!)
        loadImage.loadImage(furniture_url!!, furniture_image!!)
        loadFurnitureDescription(furniture_name)
        loadFurnitureCost(furniture_name)
        view?.findViewById<ImageView>(R.id.back_home)?.setOnClickListener {
            view?.findNavController()?.popBackStack()
        }
    }


    private fun dataBaseConnection(){
        try {
            mDBHelper?.updateDataBase()
        }
        catch (mIOException: IOException) {
            throw Error(mIOException.toString())
        }
        mDb = try {
            mDBHelper?.writableDatabase
        } catch (mSQLException: SQLException) {
            throw mSQLException
        }
    }


    private fun loadFurnitureName(tag:String){
        try{
            var product = ""
            val cursor: Cursor = mDb!!.rawQuery("SELECT name FROM furniture WHERE tag='$tag'", null)
            cursor.moveToFirst()
            product = cursor.getString(0).toString()
            cursor.close()
            view?.findViewById<TextView>(R.id.furniture_name)?.text = product
        }
        catch (e:Exception){
            Log.d("TAG", e.toString())
        }
    }


    private fun loadFurnitureDescription(tag:String){
        try{
            var product = ""
            val cursor: Cursor = mDb!!.rawQuery("SELECT details FROM furniture WHERE tag='$tag'", null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                product = cursor.getString(0).toString()
                cursor.moveToNext()
            }
            cursor.close()
            view?.findViewById<TextView>(R.id.descriprion)?.text = product
        }
        catch (e:Exception){
            Log.d("TAG", e.toString())
        }
    }


    private fun loadFurnitureCost(tag:String){
        try{
            var product = ""
            val cursor: Cursor = mDb!!.rawQuery("SELECT cost FROM furniture WHERE tag='$tag'", null)
            cursor.moveToFirst()
            product = cursor.getString(0).toString()
            cursor.close()
            view?.findViewById<TextView>(R.id.cost)?.text = product
        }
        catch (e:Exception){
            Log.d("TAG", e.toString())
        }
    }
}