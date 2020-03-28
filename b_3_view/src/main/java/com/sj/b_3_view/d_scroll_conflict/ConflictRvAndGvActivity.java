package com.sj.b_3_view.d_scroll_conflict;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sj.b_3_view.R;

import java.util.ArrayList;
import java.util.List;

public class ConflictRvAndGvActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conflict_rv_and_gv);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> childs = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                childs.add("第"+i+"个"+"第"+j+"位");
            }
            lists.add(childs);
        }
        RvWithGvAdapter adapter = new RvWithGvAdapter(this, lists);
        rv.setAdapter(adapter);
    }
}
