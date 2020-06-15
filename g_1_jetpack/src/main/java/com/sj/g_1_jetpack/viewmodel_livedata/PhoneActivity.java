package com.sj.g_1_jetpack.viewmodel_livedata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.sj.g_1_jetpack.R;
import com.sj.g_1_jetpack.databinding.ActivityPhoneBinding;

public class PhoneActivity extends AppCompatActivity {

    //定义DataBinding
    private ActivityPhoneBinding binding;
    private PhoneViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_phone);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(PhoneViewModel.class);
        //建立绑定
        binding.setVm(viewModel);
        //感应生效
        binding.setLifecycleOwner(this);

    }
}
