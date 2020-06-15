package com.example.b_1_baseview.recyclerview.first;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.b_1_baseview.R;
import com.example.b_1_baseview.recyclerview.RVAdapter;
import com.sj.commonres.adapter.BaseRVAdapter;

import java.util.ArrayList;

public class FirstRVActivity extends AppCompatActivity {
    private RecyclerView rvHorizontal;
    private RecyclerView rvGrid;
    private RecyclerView rvStream;
    private ArrayList<String> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_rv);
        rvHorizontal = (RecyclerView) findViewById(R.id.rv_horizontal);
        rvGrid = (RecyclerView) findViewById(R.id.rv_grid);
        rvStream = (RecyclerView) findViewById(R.id.rv_stream);
        rvHorizontal.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rvGrid.setLayoutManager(new GridLayoutManager(this,4));
        rvStream.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL));
        initData();
        RVAdapter adapter = new RVAdapter(this, datas);
        adapter.setItemClickListener(new BaseRVAdapter.RVItemClickListener() {
            @Override
            public void clickItem(int position) {
                Log.e("TAG", "clickItem:" + position);
                Toast.makeText(FirstRVActivity.this, "click"+position, Toast.LENGTH_SHORT).show();
            }
        });
        rvHorizontal.setAdapter(adapter);
        rvGrid.setAdapter(adapter);
        rvStream.setAdapter(adapter);
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int j = i + 1;
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < j; k++) {
                builder.append("Hello  "+i+" "+j+" "+k);
            }
            datas.add(builder.toString());
        }
    }
}
