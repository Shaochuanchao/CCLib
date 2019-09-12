package com.chuanchao.lib.ui.widget

/**
 *
 * Author: chuanchao
 * Data: 2019-08-22
 * Desc: 同步滚动监听
 *
 */
interface ObserveHScrollListener {

    fun onScrollChanged(
        scrollView: ObserveHScrollView, x: Int, y: Int,
        oldX: Int, oldY: Int
    )

    fun onFlingStarted(scrollView: ObserveHScrollView)

    fun onFlingStopped(scrollView: ObserveHScrollView)
}