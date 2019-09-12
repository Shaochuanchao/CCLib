package com.chuanchao.lib.ui

import android.view.View

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc:布局初始化相关方法定义
 *
 */
interface ILayout {

    /**
     * 获取布局ID
     */
    fun getLayoutResId(): Int

    /**
     * 是否需要下拉刷新
     */
    fun isNeedSmartRefresh(): Boolean

    /**
     * 布局初始化
     */
    fun initLayout()


    /**
     * 数据初始化（请求数据发起）
     */
    fun initData()


    fun loadingView(): View?

    /**
     * 加载方式
     */
    fun loadingBy(): ILoading.LoadingBY

}