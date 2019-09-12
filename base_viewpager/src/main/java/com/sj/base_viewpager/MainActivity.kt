package com.sj.base_viewpager

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        infinite_tv.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(Intent(this@MainActivity,InfiniteVPActivity::class.java))
            }

        })
    }

}
