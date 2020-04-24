package com.sj.b_3_view.e_custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SJ on 2020/2/29.
 */
public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        //new
        super(context);
    }


    public FlowLayout(Context context, AttributeSet attrs) {
        //xml
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        //主题style
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        //度量孩子

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams childLayoutParams = child.getLayoutParams();
            int childMeasureSpecWidth = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLayoutParams.width);
            int childMeasureSpecHeight = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLayoutParams.height);
            child.measure(childMeasureSpecWidth,childMeasureSpecHeight);
            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
        }

        //度量自己
//        setMeasuredDimension(measuredWidth,measuredHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
