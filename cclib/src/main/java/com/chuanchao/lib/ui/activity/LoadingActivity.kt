package com.chuanchao.lib.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chuanchao.lib.ui.widget.loading.DefaultLoadingImpl
import com.chuanchao.lib.ui.widget.loading.ILoading

/**
 *
 * Author: chuanchao
 * Data: 2020/6/15
 * Desc: 加载逻辑
 *
 */
open class LoadingActivity : AppCompatActivity(),
    ILoading {

    private lateinit var loadingImpl: DefaultLoadingImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        whenDestroy()
    }


    fun setUpLoading(
        loadingBy: ILoading.LoadingBY = ILoading.LoadingBY.DIALOG,
        loadingView: View? = null
    ) {
        loadingImpl = DefaultLoadingImpl(
            this,
            loadingBy,
            loadingView
        )
    }

    override fun showLoading() {
        loadingImpl.showLoading()
    }

    override fun hideLoading() {
        loadingImpl.hideLoading()
    }

    override fun whenDestroy() {
        loadingImpl.whenDestroy()
    }


}