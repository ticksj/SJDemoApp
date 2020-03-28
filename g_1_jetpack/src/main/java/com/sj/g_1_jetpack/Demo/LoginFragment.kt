package com.sj.g_1_jetpack.Demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sj.g_1_jetpack.R

/**
 * Created by SJ on 2020/3/3.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflate = layoutInflater.inflate(R.layout.fragment_login_demo, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}