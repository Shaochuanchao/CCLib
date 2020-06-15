package com.chuanchao.lib.ui.widget.loading

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: 加载方法定义
 *
 */
interface ILoading {


    enum class LoadingBY {
        /**
         * dialog加载
         */
        DIALOG,
        /**
         * 自定义样式加载
         */
        CUSTOM_VIEW,
        /**
         * smartRefresh加载
         */
        SMART_REFRESH
    }


    /**
     * 显示加载
     */
    fun showLoading()


    /**
     * 取消加载
     */
    fun hideLoading()

    /**
     * 销毁
     */
    fun whenDestroy()


}