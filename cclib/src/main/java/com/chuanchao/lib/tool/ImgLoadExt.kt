package com.chuanchao.lib.tool

import android.widget.ImageView
import com.chuanchao.lib.imgloader.IImageLoadListener
import com.chuanchao.lib.imgloader.IImageLoader
import com.chuanchao.lib.imgloader.ImageLoaderProxy

/**
 *
 * Author: chuanchao
 * Data: 2019-08-14
 * Desc: 图片扩展类
 *
 */

/**
 * 展示图片
 * @param imgPath 图片地址
 * @param type 图片展示样式
 */
fun ImageView.displayImg(imgPath: String, type: IImageLoader.DisplayType = IImageLoader.DisplayType.NORMAL) {
//    ImageLoaderProxy.instance.loader = xxLoader
    ImageLoaderProxy.instance.displayImage(imgPath, this, type)
}

/**
 * 下载图片
 * @param listener 回调
 */
fun String.loadImage(listener: IImageLoadListener) {
    if (isBlank()) {
        return
    }
    ImageLoaderProxy.instance.loadImage(this, listener)
}