package com.chuanchao.lib.ui

import android.view.View

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: view状态方法定义
 *
 */
interface IState {

    /**
     * 内容展示
     */
    fun dataView(): View

    /**
     * 空展示
     */
    fun emptyView(): View

    /**
     * 错误展示
     */
    fun errorView(): View


    /**
     * 加载view
     */
    fun loadingView(): View
}