package com.sj.b_3_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import androidx.annotation.Nullable;

public class DescriptionView extends View {

    private static final String TAG = "DescriptionView";
    private VelocityTracker velocityTracker;

    public DescriptionView(Context context) {
        super(context);
    }

    public DescriptionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DescriptionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker.addMovement(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "ACTION_DOWN X " + velocityTracker.getXVelocity());
                Log.e(TAG, "ACTION_DOWN Y " + velocityTracker.getYVelocity());
                break;
            case MotionEvent.ACTION_MOVE:
                velocityTracker.computeCurrentVelocity(1000);
                Log.e(TAG, "ACTION_MOVE X " + velocityTracker.getXVelocity());
                Log.e(TAG, "ACTION_MOVE Y " + velocityTracker.getYVelocity());
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "ACTION_UP X " + velocityTracker.getXVelocity());
                Log.e(TAG, "ACTION_UP Y " + velocityTracker.getYVelocity());
                if (velocityTracker != null) {
                    //java.lang.IllegalStateException: Already in the pool! 不添加判断 会抛出该异常，初步怀疑velocityTracker的回收
                    velocityTracker.recycle();
                }
                break;
        }
        //如果不为true 计算速度一直为0
        return true;
    }
}
