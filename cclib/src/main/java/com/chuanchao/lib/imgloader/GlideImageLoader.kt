package com.chuanchao.lib.imgloader

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.chuanchao.lib.BaseApp

/**
 *
 * Author: chuanchao
 * Data: 2019-08-14
 * Desc: 图片加载的 glide实现 (https://github.com/bumptech/glide)
 *
 */
class GlideImageLoader(override var placeHolderID: Int = 0, override var errorImaId: Int = 0) : IImageLoader {


    override fun loadImage(imgPath: String, listener: IImageLoadListener) {
        Glide.with(BaseApp.instance()).load(imgPath).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                listener.loadFail(e)
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                listener.loadSuc(resource)
                return true
            }

        }).submit()

    }


    override fun displayImage(
        imgPath: String,
        imgView: ImageView,
        type: IImageLoader.DisplayType,
        activity: Activity?,
        fragment: Fragment?,
        view: View?
    ) {

        val requestManger = when {
            activity != null -> Glide.with(activity)
            fragment != null -> Glide.with(fragment)
            view != null -> Glide.with(view)
            else -> Glide.with(BaseApp.instance())
        }

        val requestOptions = RequestOptions().apply {

            //变化
            centerCrop()
            //圆角 圆形
            when (type) {
                IImageLoader.DisplayType.ROUND_CORNER ->
                    apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
                IImageLoader.DisplayType.CIRCLE ->
                    apply(RequestOptions.bitmapTransform(CircleCrop()))
            }

            //占位图
            if (placeholderId != 0) {
                placeholder(placeholderId)
            }
            //错误图
            if (errorId != 0) {
                error(errorId)
            }

            //缓存
            diskCacheStrategy(DiskCacheStrategy.ALL)
        }

        requestManger
            .load(imgPath)
            .apply(requestOptions)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imgView)
    }


}