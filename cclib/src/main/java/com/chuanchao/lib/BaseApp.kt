package com.chuanchao.lib

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.chuanchao.lib.constant.BCConstant
import com.chuanchao.lib.tool.SimpleLifecycleCallback
import com.scwang.smartrefresh.header.WaveSwipeHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: Application基类，主工程Application需要继承它
 */
open class BaseApp : Application() {


    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            WaveSwipeHeader(context)
        }
    }

    companion object {
        private lateinit var instance: BaseApp
        @JvmStatic
        fun instance() = instance
    }


    var curActivityCount = 0

    override fun onCreate() {
        super.onCreate()
        instance = this

        registerActivityLifecycleCallbacks(lifecycleCallbacks)
    }


    /**
     * 处理Activity生命周期相关
     */
    private val lifecycleCallbacks = object : SimpleLifecycleCallback() {

        override fun onActivityResumed(p0: Activity) {
            super.onActivityResumed(p0)
            if (curActivityCount == 0) {
                LocalBroadcastManager.getInstance(this@BaseApp)
                    .sendBroadcast(Intent(BCConstant.APP_TO_FRONT))
            }
            curActivityCount++
        }

        override fun onActivityStopped(p0: Activity) {
            super.onActivityStopped(p0)
            curActivityCount--
            if (curActivityCount == 0) {
                LocalBroadcastManager.getInstance(this@BaseApp)
                    .sendBroadcast(Intent(BCConstant.APP_TO_BACKGROUND))
            }
        }

    }

    /**
     * 根据是否有当前activity判断程序前后台
     */
    fun isAppInBackground() = curActivityCount == 0

}