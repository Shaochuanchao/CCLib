package com.chuanchao.lib.imgloader

import android.graphics.drawable.Drawable

/**
 *
 * Author: chuanchao
 * Data: 2019-08-14
 * Desc: 图片加载监听
 *
 */
interface IImageLoadListener {


    /**
     * 加载成功
     * @param drawable 成功后返回的图片
     */
    fun loadSuc(drawable: Drawable?)


    /**
     * 加载失败
     * @param throwable 失败后返回
     */
    fun loadFail(throwable: Throwable?)
}