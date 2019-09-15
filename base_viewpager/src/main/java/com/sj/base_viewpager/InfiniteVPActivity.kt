package com.sj.base_viewpager

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_infinite_vp.*

class InfiniteVPActivity : AppCompatActivity() {

    var pics = mutableListOf<Int>()
    var startAutoScroll = false

    var handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when{
                msg.what == 0 -> vp.setCurrentItem(vp.currentItem + 1)
                msg.what == 1 -> startScroll()
                msg.what == 2 -> stopScroll()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite_vp)
        pics.add(R.drawable.p1)
        pics.add(R.drawable.p2)
        pics.add(R.drawable.p3)
        initVP()
//        FuncationOne()
        FuncationTwo()
//        FuncationThree()
        handler.sendEmptyMessage(1)
    }

    private fun initVP() {
        try {
            var field = ViewPager::class.java.getDeclaredField("mScroller")
            field.isAccessible = true
            field.set(vp, VPSpeedScroller(3000,this@InfiniteVPActivity));
        } catch (e: Exception) {
            e.printStackTrace()
        }
        vp.setOnTouchListener(object :View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                when{
                    p1!!.action == MotionEvent.ACTION_UP ->startScroll()
                    else -> handler.sendEmptyMessage(2)
                }
                return false
            }
        })
    }


    private fun startScroll() {
        if (thread.state == Thread.State.RUNNABLE) {
            return
        }
        if (startAutoScroll) {
        }
        startAutoScroll = true
        thread.start()
    }
    private fun stopScroll() {
        thread
        if (thread.state == Thread.State.RUNNABLE) {
            return
        }
        if (startAutoScroll) {
        }
        startAutoScroll = true

        thread.start()
    }
    lateinit var thread :Thread
    /**
     * 伪无限实现
     */
    private fun FuncationOne() {
        var adapter = VPAdapter1(this, pics)
        vp.adapter = adapter
        var position = Int.MAX_VALUE / 2 - Int.MAX_VALUE / 2 / pics.size
        vp.currentItem = position
    }

    /**
     * 真无限实现
     */
    private fun FuncationTwo() {
        val pics2 = mutableListOf<Int>()
        pics2.add(pics[pics.size - 1])
        pics2.addAll(pics)
        pics2.add(pics[0])

        vp.adapter = VPAdapter2(this, pics2)
        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            var currPosition: Int = 0

            override fun onPageScrollStateChanged(state: Int) {
//                SCROLL_STATE_DRAGGING——正在被用户拖拽滑动状态
//                SCROLL_STATE_SETTLING——被用户拖动并松手后，ViewPager自动滑动，即将归于停止的状态
//                SCROLL_STATE_IDLE——被用户滑动后的最终静止状态
                if (state != ViewPager.SCROLL_STATE_IDLE) return
                var adapter = vp.adapter as VPAdapter2
                when {
                    currPosition == 0 -> vp.setCurrentItem(adapter.list.size - 2, false)
                    currPosition == adapter.list.size - 1 -> vp.setCurrentItem(1, false)
                }

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                currPosition = position

            }
        })
        vp.currentItem = 1
    }

    /**
     * 平滑替换测试
     */
    private fun FuncationThree() {
        val pics2 = mutableListOf<Int>()
        pics2.add(pics[0])
        pics2.add(pics[1])
        pics2.add(pics[0])
        vp.adapter = VPAdapter2(this, pics2)
        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            var currPosition: Int = 0

            override fun onPageScrollStateChanged(state: Int) {
                if (state != ViewPager.SCROLL_STATE_IDLE) {
                    return
                }
                if (currPosition == pics2.size - 1) {
                    vp.setCurrentItem(0, false)
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                currPosition = position

            }
        })

    }


    class VPAdapter1(var context: Context, var list: MutableList<Int>) : PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return Int.MAX_VALUE
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var view = ImageView(context)
            view.scaleType = ImageView.ScaleType.FIT_START
            view.setImageResource(list[position % list.size])
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }


    class VPAdapter2(var context: Context, var list: MutableList<Int>) : PagerAdapter() {

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount() = list.size

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var view = ImageView(context)
            view.scaleType = ImageView.ScaleType.FIT_START
            view.setImageResource(list[position])
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }

}
