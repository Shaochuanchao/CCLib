package com.chuanchao.lib.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.HorizontalScrollView
import kotlin.math.abs

/**
 *
 * Author: chuanchao
 * Data: 2019-08-22
 * Desc: 横向滚动scroll，带监听 (股票 联动列表用)
 *
 */
class ObserveHScrollView(context: Context, attrs: AttributeSet) :
    HorizontalScrollView(context, attrs) {

    var lastScrollX = 0
    var lastScrollY = 0

    //上一次触摸的 x 位置
    private var mLastX = 0f
    //上一次触摸的 y 位置
    private var mLastY = 0f

    companion object {
        const val DELAY_MILLIS = 100
    }

    var scrollListener: ObserveHScrollListener? = null

    lateinit var scrollChecker: Runnable


    init {
        scrollChecker = Runnable {
            if (lastScrollX == scrollX && lastScrollY == scrollY) {
                scrollListener?.onFlingStopped(this)
                removeCallbacks(scrollChecker)
            } else {
                lastScrollY = scrollY
                lastScrollX = scrollX
                postDelayed(scrollChecker, DELAY_MILLIS.toLong())
            }
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //记录down的位置
                mLastX = event.x
                mLastY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                val moveX = abs(event.x - mLastX)
                val moveY = abs(event.y - mLastY)

                //如果是横向滑动并且到头了，则不进行事件处理，交回给交控件
                if (moveX > moveY) {
                    val canScroll = canScrollHorizontally((mLastX - event.x).toInt())
                    if (!canScroll) {
                        return false
                    }
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        scrollListener?.onScrollChanged(this, l, t, oldl, oldt)
    }


    override fun fling(velocityX: Int) {
        super.fling(velocityX)
        scrollListener?.onFlingStarted(this)
        post(scrollChecker)
    }

}