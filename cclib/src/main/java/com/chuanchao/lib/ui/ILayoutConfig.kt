package com.chuanchao.lib.ui

import android.view.View

/**
 *
 * Author: chuanchao
 * Data: 2019-09-12
 * Desc: 各种状态view
 *
 */
interface ILayoutConfig {


    /**
     * 正常 展示
     */
    fun contentView(): View?

    /**
     * 错误 展示
     */
    fun errorView(): View?


    /**
     * 数据 空展示
     */
    fun emptyView(): View?


    /**
     * 加载中 展示
     */
    fun loadingView(): View?

}