package com.chuanchao.lib.ui

/**
 *
 * Author: chuanchao
 * Data: 2019-09-12
 * Desc: navigation相关定义
 *
 */
interface INav {


    /**
     * 返回icon
     */
    fun backDrawableId(): Int

    /**
     * 是否显示返回，默认逻辑处理，一般不需要特殊操作
     */
    fun showBackIcon(): Boolean

}