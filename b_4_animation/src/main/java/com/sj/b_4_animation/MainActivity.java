package com.sj.b_4_animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private View baseAnimationView;
    private View objectView;
    private View fAnimaitonView;
    private LinearLayout content_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        baseAnimationView = findViewById(R.id.iv1);
        objectView = findViewById(R.id.iv2);
        fAnimaitonView = findViewById(R.id.f_iv);
        content_ll = (LinearLayout) findViewById(R.id.content_ll);
        Animation aSet = AnimationUtils.loadAnimation(this, R.anim.animation_set_1);
        LayoutAnimationController controller = new LayoutAnimationController(aSet);
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        controller.setDelay(0.5f);
        content_ll.setLayoutAnimation(controller);
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
        findViewById(R.id.object_a1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectTranslationX();
            }
        });
        findViewById(R.id.object_a2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectScaleX();
            }
        });
        findViewById(R.id.object_a3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectRotation();
            }
        });
        findViewById(R.id.object_a4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectAlpha();
            }
        });
        findViewById(R.id.object_a5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectColor();
            }
        });
        findViewById(R.id.object_a6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectSet();
            }
        });
        findViewById(R.id.object_a7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectYWithInterpolatorEvaluator();
            }
        });
        findViewById(R.id.object_a8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectYWithListener();
            }
        });
        findViewById(R.id.object_a9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeObjectYWithUpdateListener();
            }
        });
        findViewById(R.id.f_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable();
            }
        });
    }


    // ---------------------基础动画----------------------------------------------
    private void animationDrawable() {
        fAnimaitonView.setBackgroundResource(R.drawable.drawable_animation);
        ((AnimationDrawable) fAnimaitonView.getBackground()).start();
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
        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        RotateAnimation ra = new RotateAnimation(0, 360, 0, 0);
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        AnimationSet animationSet = new AnimationSet(true);
        ta.setDuration(1000);
        sa.setDuration(1000);
        ra.setDuration(1000);
        aa.setDuration(1000);
        animationSet.addAnimation(ta);
        animationSet.addAnimation(sa);
        animationSet.addAnimation(ra);
        animationSet.addAnimation(aa);
        animationSet.setDuration(1000);
        baseAnimationView.startAnimation(animationSet);
        Animation a = AnimationUtils.loadAnimation(this, R.anim.base_animation);
        baseAnimationView.startAnimation(a);
    }

    // ---------------------属性动画----------------------------------------------
    private void changeObjectTranslationX() {
        ObjectAnimator.ofFloat(objectView, "translationX", 100)
                .setDuration(2000)
                .start();
    }

    private void changeObjectScaleX() {
        ObjectAnimator.ofFloat(objectView, "scaleX", 0, 1, 2, 1)
                .setDuration(2000)
                .start();
    }

    private void changeObjectRotation() {
        ObjectAnimator.ofFloat(objectView, "rotation", 0, 100, 180, 360)
                .setDuration(2000)
                .start();
    }

    private void changeObjectAlpha() {
        ObjectAnimator.ofFloat(objectView, "alpha", 0f, 0.2f, 0.5f, 0.7f, 1f)
                .setDuration(2000)
                .start();
    }

    private void changeObjectColor() {
        ObjectAnimator.ofInt(objectView, "backgroundColor", 0xFFFF0000, 0xFFFB742E)
                .setDuration(2000)
                .start();
    }

    private void changeObjectSet() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(objectView, "translationX", 100),
                ObjectAnimator.ofFloat(objectView, "scaleX", 0, 1, 2, 1),
                ObjectAnimator.ofFloat(objectView, "rotation", 0, 100, 180, 360),
                ObjectAnimator.ofFloat(objectView, "alpha", 0f, 0.2f, 0.5f, 0.7f, 1f),
                ObjectAnimator.ofInt(objectView, "backgroundColor", 0xFFFF0000, 0xFFFB742E)
        );
//        set.setDuration(2000).start();
        set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.obejct_animation_set);
        set.setTarget(objectView);
        set.start();
    }


    private void changeObjectYWithInterpolatorEvaluator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(objectView, "translationY", 0, 1000);
        animator.setDuration(2000);
        animator.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                Log.e(TAG, "getInterpolation: =" + input);
                return input;
            }
        });
        animator.setEvaluator(new TypeEvaluator<Float>() {
            @Override
            public Float evaluate(float fraction, Float startValue, Float endValue) {
                float v = startValue + fraction * (endValue - startValue);
                Log.e(TAG, "evaluate: fraction = " + fraction + "currV==" + v);
                return v;
            }
        });
        animator.start();
    }

    private void changeObjectYWithListener() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(objectView, "translationY", 0, 1000);
        animator.setDuration(2000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.e(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.e(TAG, "onAnimationEnd: " );
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                Log.e(TAG, "onAnimationCancel: " );
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                Log.e(TAG, "onAnimationRepeat: ");
            }
            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
                Log.e(TAG, "onAnimationPause: " );
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
                Log.e(TAG, "onAnimationResume: " );
            }
        });
        animator.addPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animation) {
                //暂停时调用
            }

            @Override
            public void onAnimationResume(Animator animation) {
                //恢复时调用
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //开始时调用
                Log.e(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //结束时调用
                Log.e(TAG, "onAnimationEnd: " );
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //取消时调用
                Log.e(TAG, "onAnimationCancel: " );
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                //重复时调用
                Log.e(TAG, "onAnimationRepeat: ");
            }
        });
        animator.start();
    }

    private void changeObjectYWithUpdateListener() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(objectView, "translationY", 0, 1000);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e(TAG, "onAnimationUpdate: animation.getAnimatedFraction()=="+animation.getAnimatedFraction() );
            }
        });
    }

}
