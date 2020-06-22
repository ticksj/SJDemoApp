package com.sj.b_3_view.a_base;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.b_3_view.R;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private View targetV;
    private TextView tv;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        targetV = findViewById(R.id.target_v);
        tv = ((TextView) findViewById(R.id.tv));
        initView();
    }

    private void initView() {
        targetV.getLeft()   ;//View 最左边相对与ViewGroup的距离
        targetV.getRight()  ;//View 最右边相对与ViewGroup的距离（可与getLeft()来获取View的宽度）
        targetV.getTop()    ;//View 最上边相对与ViewGroup的距离
        targetV.getBottom()     ;//View 最下边相对与ViewGroup的距离（可与getTop()来获取View的高度）
        targetV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                motionEvent.getX() ; //触摸点     相对于View的X坐标
                motionEvent.getY() ; //触摸点     相对于View的Y坐标
                motionEvent.getRawX()  ; //触摸点     相对于屏幕的X坐标（可与getX()来获取View相对与屏幕的左边距离）
                motionEvent.getRawY()  ; //触摸点     相对于屏幕的Y坐标（可与getY()来获取View相对与屏幕的上边距离）

                string = "最左边相对与ViewGroup的距离:targetV.getLeft() = " + targetV.getLeft() + "\n" +
                        "最右边相对与ViewGroup的距离:targetV.getRight() = " + targetV.getRight() + "\n" +
                        "最上边相对与ViewGroup的距离:targetV.getTop() = " + targetV.getTop() + "\n" +
                        "最下边相对与ViewGroup的距离:targetV.getBottom() = " + targetV.getBottom() + "\n";
                String msg =
                        "相对于View的X坐标:motionEvent.getX()="+motionEvent.getX()+"\n"+
                        "相对于View的Y坐标:motionEvent.getY()="+motionEvent.getY()+"\n"+
                        "相对于屏幕的X坐标:motionEvent.getRawX()="+motionEvent.getRawX()+"\n"+
                        "相对于屏幕的Y坐标:motionEvent.getRawY()="+motionEvent.getRawY()+"\n";
                tv.setText(string+msg);
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        string = "最左边相对与ViewGroup的距离:targetV.getLeft() = " + targetV.getLeft() + "\n" +
                "最右边相对与ViewGroup的距离:targetV.getRight() = " + targetV.getRight() + "\n" +
                "最上边相对与ViewGroup的距离:targetV.getTop() = " + targetV.getTop() + "\n" +
                "最下边相对与ViewGroup的距离:targetV.getBottom() = " + targetV.getBottom() + "\n";

    }

}
