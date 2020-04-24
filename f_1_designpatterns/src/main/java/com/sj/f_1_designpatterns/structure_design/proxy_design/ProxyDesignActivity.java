package com.sj.f_1_designpatterns.structure_design.proxy_design;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.sj.f_1_designpatterns.R;
import com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor.HttpCallback;
import com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor.HttpHelper;
import com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor.ProxyOkhttp;
import com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor.ProxyVolley;
import com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor.ProxyXutils;
import com.sj.f_1_designpatterns.structure_design.proxy_design.httpprocessor.TestBean;

public class ProxyDesignActivity extends AppCompatActivity {

    private String imageUrl = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/3/22";
    private static final String TAG = "ProxyDesignActivity";
    private LinearLayout llContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_design);
        llContent = findViewById(R.id.ll_content);
        findViewById(R.id.tv_volley).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Volley请求
                HttpHelper.init(new ProxyVolley(ProxyDesignActivity.this));
                getNetData();

            }
        });
        findViewById(R.id.tv_xutils).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xutils请求
                HttpHelper.init(new ProxyXutils());
                getNetData();
            }
        });
        findViewById(R.id.tv_okhttp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Okhttp请求
                HttpHelper.init(new ProxyOkhttp());
                getNetData();
            }
        });
        findViewById(R.id.tv_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    private void getNetData() {
        Toast.makeText(this,"开始请求",Toast.LENGTH_SHORT).show();
        HttpHelper.getHttpHelper().get(imageUrl, null, new HttpCallback<TestBean>() {
            @Override
            protected void onSuccess(TestBean testBean) {
                Toast.makeText(ProxyDesignActivity.this,"finish",Toast.LENGTH_SHORT).show();
                showImageView(testBean);
            }
        });
    }

    private void showImageView(TestBean testBean) {
        Toast.makeText(this,"图片加载",Toast.LENGTH_SHORT).show();
        for (TestBean.ResultsBean result : testBean.getResults()) {
            String url = result.getUrl();
            Log.e(TAG, "onSuccess: "+url );
            ImageView imageView = new ImageView(this);
            Glide.with(ProxyDesignActivity.this).load(url).into(imageView);
            llContent.addView(imageView);
        }
    }
}
