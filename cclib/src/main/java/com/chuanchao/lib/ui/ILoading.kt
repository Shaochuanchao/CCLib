package com.chuanchao.lib.ui

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
        CUTOM_VIEW,
        /**
         * smartRefresh加载
         */
        SMART_REFRESH
    }


//    companion object {
//        //加载方式定义
//        const val BY_DIALOG = 0
//        const val BY_VIEW = 1
//        const val BY_SWAP = 2
//
//        @IntDef(BY_DIALOG, BY_VIEW, BY_SWAP)
//        @Retention(AnnotationRetention.SOURCE)
//        annotation class LoadingBY
//    }


    /**
     * 显示加载
     */
    fun showLoading()


    /**
     * 取消加载
     */
    fun hideLoading()


    /**
     * 加载方式
     */
    fun loadingBy(): LoadingBY
}