package com.example.paradise

import android.widget.ImageView
import com.squareup.picasso.Picasso

class LoadImage {
    fun loadImage(url: String, imageView: ImageView){
        Picasso.get().load(url).into(imageView)
    }
}