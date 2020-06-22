package com.example.b_1_baseview.baseview;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_1_baseview.R;

public class EdittextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

    }
    public void hide(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
    TextView.OnEditorActionListener listener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_NULL:
                    // actionUnspecified  默认值，根据设备的情况显示动作。
                    //处理事件
                    return true;
                case EditorInfo.IME_ACTION_GO:
                    // actionGo  在 Enter 键上显示 Go。
                    //处理事件
                    return true;
                case EditorInfo.IME_ACTION_SEARCH:
                    // ActionSearch  在 Enter 键上显示 Search。
                    //处理事件
                    return true;
                case EditorInfo.IME_ACTION_SEND:
                    // actionSend  在 Enter 键上显示 Send。
                    //处理事件
                    return true;
                case EditorInfo.IME_ACTION_NEXT:
                    // antionNest  在 Enter 键上显示 Nest。
                    //处理事件
                    return true;
                case EditorInfo.IME_ACTION_DONE:
                    // actionDone  在 Enter 键上显示 Done。
                    //处理事件
                    return true;
            }
            return false;//true 表示已处理该事件
        }
    };
}