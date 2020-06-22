package com.example.b_1_baseview.recyclerview.second.scroll;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 协助整页滚动，自动回弹
 */
public abstract class PageScrollListener extends RecyclerView.OnScrollListener {
    int scrollDistance = 0;  //总的滚动距离
    boolean isHorizontalScroll;

    public PageScrollListener(boolean isWidth) {
        this.isHorizontalScroll = isWidth;
    }

    /**
     * @param recyclerView
     * @param newState     SCROLL_STATE_IDLE = 0      （静止没有滚动）
     *                     SCROLL_STATE_DRAGGING = 1  （正在被外部拖拽,一般为用户正在用手指滚动）
     *                     SCROLL_STATE_SETTLING = 2  （自动滚动）
     */
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (newState == 0) {
            int maxDistance = isHorizontalScroll ? recyclerView.getWidth() : recyclerView.getHeight();
            int p = scrollDistance / maxDistance;
            int offset = scrollDistance % maxDistance;
            if (offset > maxDistance / 2) {
                p++;
            }
            pageScrollFinishCallBack(p);
            int needScroll = p * maxDistance - scrollDistance;
            recyclerView.smoothScrollBy(isHorizontalScroll ? needScroll : 0, isHorizontalScroll ? 0 : needScroll);
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        scrollDistance += isHorizontalScroll ? dx : dy;
        int maxDistance = isHorizontalScroll ? recyclerView.getWidth() : recyclerView.getHeight();
        int p = scrollDistance / maxDistance;
        if (scrollDistance % maxDistance >0) {
            p++;
        }
        pageScrollingCallBack(p);
    }

    public abstract void pageScrollFinishCallBack(int page);
    public abstract void pageScrollingCallBack(int page);

}