package com.sj.base_viewpager

import android.content.Context
import android.widget.Scroller

/**
 * Created by SJ on 2019/9/13.
 */
class VPSpeedScroller(var mDuration: Int,context: Context): Scroller(context) {
    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
        super.startScroll(startX, startY, dx, dy,mDuration)
    }

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
        super.startScroll(startX, startY, dx, dy, mDuration)
    }

}