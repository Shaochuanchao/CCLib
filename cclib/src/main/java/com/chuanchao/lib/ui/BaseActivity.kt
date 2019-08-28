package com.chuanchao.lib.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chuanchao.lib.ui.widget.LoadingDialog
import com.scwang.smartrefresh.layout.SmartRefreshLayout

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: activity 基类,实现默认加载实现
 *
 */
abstract class BaseActivity : AppCompatActivity(), ILayout, ILoading {


    /**
     * dialo加载框,不用byLazy为了避免不必要的初始化
     */
    private var loadingDialog: LoadingDialog? = null

    private var smartRefreshLayout: SmartRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        initLayout()
        initData()
    }


    override fun showLoading() {
        when (loadingBy()) {
            ILoading.LoadingBY.DIALOG -> {
                if (loadingDialog == null) {
                    loadingDialog = LoadingDialog.loadingDialog(this@BaseActivity)
                }
                loadingDialog?.show()
            }
            ILoading.LoadingBY.SMART_REFRESH -> smartRefreshLayout?.autoRefresh()
            else -> loadingView()?.visibility = View.VISIBLE
        }
    }


    override fun hideLoading() {
        when (loadingBy()) {
            ILoading.LoadingBY.DIALOG -> loadingDialog?.dismiss()
            ILoading.LoadingBY.SMART_REFRESH -> smartRefreshLayout?.finishRefresh()
            else -> loadingView()?.visibility = View.GONE
        }
    }

    override fun loadingView(): View? {

        if (ILoading.LoadingBY.DIALOG == loadingBy()) {
            return null
        }

        if (smartRefreshLayout != null) {
            return smartRefreshLayout
        }

        return loadingView()
    }

    override fun onDestroy() {
        super.onDestroy()
        val isShowing = loadingDialog?.isShowing
        if (isShowing != null && isShowing) {
            loadingDialog?.dismiss()
            loadingDialog = null
        }

    }

}