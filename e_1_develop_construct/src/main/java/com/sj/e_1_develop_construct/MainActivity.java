package com.sj.e_1_develop_construct;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.e_1_develop_construct.mvvm.MVVMSimple;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MVVMSimple.ViewModel(new MVVMSimple.ViewBinder(),findViewById(R.id.tv)).load();

    }
}
