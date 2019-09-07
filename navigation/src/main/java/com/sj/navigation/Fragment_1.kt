package com.sj.sjnavigation

import android.os.Bundle
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import com.sj.navigation.R
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment_1 : BaseFragment(){
    override var layoutId = R.layout.fragment_1;


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fg.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_fragment_1_to_fragment_2)
        }
    }

}