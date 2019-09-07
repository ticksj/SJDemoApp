package com.sj.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navController = Navigation.findNavController(this, R.id.nav_host_fg)
        bnv.setupWithNavController(navController)
    }





    override fun onSupportNavigateUp() =
        findNavController(this, R.id.nav_host_fg).navigateUp()
}
