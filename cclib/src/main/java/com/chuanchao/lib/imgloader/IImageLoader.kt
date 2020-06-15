package com.chuanchao.lib.imgloader

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

/**
 *
 * Author: chuanchao
 * Data: 2019-08-14
 * Desc: 图片加载方法定义
 *
 */
interface IImageLoader {


    var placeHolderID: Int
    var errorImaId: Int

    /**
     * 图片展示类型
     */
    enum class DisplayType {
        /**
         * 普通
         */
        NORMAL,
        /**
         * 圆角
         */
        ROUND_CORNER,
        /**
         * 圆形
         */
        CIRCLE
    }


    /**
     * 从网络下载图片
     * @param imgPath 图片链接
     * @param listener 回掉
     */
    fun loadImage(imgPath: String, listener: IImageLoadListener)


    /**
     * 展示网络图片
     * @param imgPath 图片链接
     * @param imgView ImageView
     * @param type 图片展示类型
     * @param activity 加载所在activity，用于生命周期相关处理
     * @param fragment 加载所在fragment，用户生命周期相关处理
     * @param  view 加载所在view，用户生命周期处理
     */
    fun displayImage(
        imgPath: String, imgView: ImageView, type: DisplayType = DisplayType.NORMAL
        , activity: Activity? = null, fragment: Fragment? = null,view: View?=null
    )

}