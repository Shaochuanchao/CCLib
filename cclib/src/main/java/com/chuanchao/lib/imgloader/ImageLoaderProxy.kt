package com.chuanchao.lib.imgloader

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

/**
 *
 * Author: chuanchao
 * Data: 2019-08-14
 * Desc: 图片加载代理
 *
 */
class ImageLoaderProxy(
    override var placeHolderID: Int = 0, override var errorImaId: Int = 0,
    val loader: IImageLoader
) : IImageLoader {


    companion object {

        val instance: ImageLoaderProxy by lazy {
            ImageLoaderProxy(loader = GlideImageLoader())
        }
    }

    override fun loadImage(imgPath: String, listener: IImageLoadListener) {
        loader.loadImage(imgPath, listener)
    }

    override fun displayImage(
        imgPath: String,
        imgView: ImageView,
        type: IImageLoader.DisplayType,
        activity: Activity?,
        fragment: Fragment?,
        view: View?
    ) {
        loader.displayImage(imgPath, imgView, type, activity, fragment, view)
    }


}