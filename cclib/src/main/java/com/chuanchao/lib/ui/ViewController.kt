package com.chuanchao.lib.ui

import android.view.View
import android.widget.FrameLayout

/**
 *
 * Author: chuanchao
 * Data: 2019-09-12
 * Desc: //TODO
 *
 */
class ViewController(
    val container: FrameLayout,
    val layouConfig: ILayoutConfig,
    val loading: ILoading,
    var curStatus: ViewStatus = ViewStatus.CONTENT
) {


    var contentView: View? = null


    init {

    }


    fun changeViewStatus(viewStatus: ViewStatus) {

        var targetView = container.findViewWithTag<View>(viewStatus)

        if (targetView == null) {
            targetView = initViewWithStatus(viewStatus)
            targetView?.tag = viewStatus
            container.addView(targetView ?: return, matchParams())
        }

        repeat(container.childCount) {
            val childView = container.getChildAt(it)
            if (viewStatus == childView.tag) {
                childView.visibility = View.VISIBLE
            } else {
                childView.visibility = View.GONE
            }
        }

    }

    /**
     * 按状态初始化加载
     * @param viewStatus  状态
     */
    private fun initViewWithStatus(viewStatus: ViewStatus) = when (viewStatus) {
        ViewStatus.CONTENT -> layouConfig.contentView()
        ViewStatus.EMPTY -> layouConfig.emptyView()
        ViewStatus.ERROR -> layouConfig.errorView()
        ViewStatus.LOADING -> layouConfig.loadingView()
    }


    /**
     * 默认match
     */
    private fun matchParams(): FrameLayout.LayoutParams {
        return FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
    }

}