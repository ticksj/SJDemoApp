package com.sj.base_animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private View baseAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        baseAnimationView = findViewById(R.id.iv1);
        findViewById(R.id.base_a1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseAnimationTranslateAnimation();
            }
        });
        findViewById(R.id.base_a2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseAnimationScaleAnimation();
            }
        });
        findViewById(R.id.base_a3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseAnimationRotateAnimation();
            }
        });
        findViewById(R.id.base_a4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseAnimationAlphaAnimation();
            }
        });
        findViewById(R.id.base_a5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseAnimationSet();
            }
        });
    }

    private void baseAnimationTranslateAnimation() {
        //fromXDelta,toXDelta,fromYDelta,toYDelta
        //起点X，终点X，起点Y，终点Y  值为与当前view的X,Y比较后的差值
        TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 300);
        ta.setDuration(1000);
        baseAnimationView.startAnimation(ta);
        ta.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //复杂动画实现
                //fromXType,fromXValue, toXType,toXValue,fromYType,fromYValue, toYType,toYValue
                //起点X方向参照值,起点X，终点X方向参照值,终点X，起点Y方向参照值,起点Y，终点Y方向参照值,终点Y
                TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1,
                        Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1);
                ta.setDuration(2000);
                baseAnimationView.startAnimation(ta);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void baseAnimationScaleAnimation() {
        ScaleAnimation sa = new ScaleAnimation(4, 1, 4, 1);
        sa.setDuration(2000);
        baseAnimationView.startAnimation(sa);
        sa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //复杂动画实现
                //起始X倍数，最终X倍数，起始Y倍数，最终X倍数
                ScaleAnimation sa = new ScaleAnimation(4, 2, 4, 2,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                sa.setDuration(1000);
                baseAnimationView.startAnimation(sa);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void baseAnimationRotateAnimation() {
//        RotateAnimation ra = new RotateAnimation(0, 360, 0, 0);
        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(1000);
        baseAnimationView.startAnimation(ra);
    }

    private void baseAnimationAlphaAnimation() {
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1000);
        baseAnimationView.startAnimation(aa);
    }

    private void baseAnimationSet() {
        TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 0);
        ScaleAnimation sa = new ScaleAnimation(4, 2, 4, 2,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
//        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        RotateAnimation ra = new RotateAnimation(0, 360, 0, 0);
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        AnimationSet animationSet = new AnimationSet(true);
        ta.setDuration(1000);
        sa.setDuration(1000);
        ra.setDuration(1000);
        aa.setDuration(1000);
        animationSet.addAnimation(ta);
//        animationSet.addAnimation(sa);
        animationSet.addAnimation(ra);
//        animationSet.addAnimation(aa);
        animationSet.setDuration(1000);
        baseAnimationView.startAnimation(animationSet);
    }
}
