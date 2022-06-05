package com.example.paradise

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.paradise.databinding.ActivityMainBinding
import com.example.paradise.ui.basket.BasketFragment
import com.example.paradise.ui.favourites.FavouritesFragment
import com.example.paradise.ui.home.HomeFragment
import com.example.paradise.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    public lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = applicationContext
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)
        if(Build.VERSION.SDK_INT >= 23){
            val view = window.decorView
            var flags: Int = view.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
            this.window.statusBarColor = Color.WHITE
        }



//        val badge = navView.getOrCreateBadge(R.id.navigation_basket)
//        badge.isVisible = true
//        badge.backgroundColor = resources.getColor(R.color.blue)
    }
}