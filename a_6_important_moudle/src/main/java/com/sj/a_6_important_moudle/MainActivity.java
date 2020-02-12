package com.sj.a_6_important_moudle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sj.a_6_important_moudle.handler.CustomHandler;
import com.sj.a_6_important_moudle.handler.CustomLooper;
import com.sj.a_6_important_moudle.handler.CustomMessage;

import java.lang.ref.WeakReference;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView msgTv;


   Handler handler =  new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.handler_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerThread();
            }
        });
        findViewById(R.id.handler_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerMoreThread();
            }
        });
    }
    private void handlerThread() {
        CustomLooper.prepare();
        final CustomHandler customHandler = new CustomHandler() {
            @Override
            public void handleMessage(CustomMessage message) {
                Log.e(TAG, "receive:" + message.toString());
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    CustomMessage message = new CustomMessage();
                    String msg = "第" + i + "次交互：send " + UUID.randomUUID().toString();
                    Log.e(TAG, msg);
                    message.setObject(msg);
                    customHandler.sendMessage(message);
                }
            }
        }).start();
        CustomLooper.loop();
    }


    private void handlerMoreThread() {
        CustomLooper.prepare();
        final CustomHandler customHandler = new CustomHandler() {
            @Override
            public void handleMessage(CustomMessage message) {
                Log.e(TAG, "receive:" + message.toString());
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        CustomMessage message = new CustomMessage();
                        String msg = Thread.currentThread().getName()+":第" + i + "次交互：send " + UUID.randomUUID().toString();
                        Log.e(TAG, msg);
                        message.setObject(msg);
                        customHandler.sendMessage(message);
                    }
                }
            }).start();
        }
        CustomLooper.loop();
    }


    private static class MyHandler extends CustomHandler{
        WeakReference<Activity> weakReference;

        public MyHandler(Activity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(CustomMessage message) {

        }
    }

}
