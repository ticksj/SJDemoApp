package com.example.b_1_baseview.recyclerview.second;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b_1_baseview.R;
import com.example.b_1_baseview.recyclerview.RVMatchBorderAdapter;
import com.example.b_1_baseview.recyclerview.second.scroll.PageScrollListener;

import java.util.ArrayList;
//1. itemanimator 动画
//2. 分割线

public class SecondRVActivity extends AppCompatActivity {
    private RecyclerView rvHorizontal;
    private RecyclerView rvGrid;
    private RecyclerView rvStream;
    private ArrayList<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_rv);
        rvGrid = (RecyclerView) findViewById(R.id.rv_grid);
//        CustomLayoutManger layout = new CustomLayoutManger(1.5f,0.85f);
        rvGrid.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL,false));
        initData();
        RVMatchBorderAdapter adapter = new RVMatchBorderAdapter(this, datas);
        rvGrid.setAdapter(adapter);
        rvGrid.addOnScrollListener(new PageScrollListener(false) {
            @Override
            public void pageScrollFinishCallBack(int page) {

            }

            @Override
            public void pageScrollingCallBack(int page) {

            }
        });
        rvGrid.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("Hello  "+i);
        }
    }
}
