package com.chuanchao.lib.ui

import android.content.Context
import android.view.View
import com.chuanchao.lib.ui.widget.LoadingDialog
import com.scwang.smartrefresh.layout.SmartRefreshLayout

/**
 *
 * Author: chuanchao
 * Data: 2019-09-12
 * Desc: 加载逻辑默认处理
 *
 */

open class DefaultLoadingImpl(
    val context: Context,
    val loadingBY: ILoading.LoadingBY,
    val loadingView: View? = null
) :
    ILoading {

    /**
     * dialo加载框,不用byLazy为了避免不必要的初始化
     */
    var loadingDialog: LoadingDialog? = null

    var smartRefreshLayout: SmartRefreshLayout? = null


    override fun showLoading() {

        when (loadingBY) {
            ILoading.LoadingBY.DIALOG -> {
                if (loadingDialog == null) {
                    loadingDialog = LoadingDialog.loadingDialog(context)
                }
                loadingDialog?.show()
            }
            ILoading.LoadingBY.SMART_REFRESH -> smartRefreshLayout?.autoRefresh()
            else -> loadingView?.visibility = View.VISIBLE
        }

    }

    override fun hideLoading() {

        when (loadingBY) {
            ILoading.LoadingBY.DIALOG -> loadingDialog?.dismiss()
            ILoading.LoadingBY.SMART_REFRESH -> smartRefreshLayout?.finishRefresh()
            else -> loadingView?.visibility = View.GONE
        }
    }

    override fun whenDestroy() {
        if (loadingDialog?.isShowing == true) {
            loadingDialog?.dismiss()
            loadingDialog = null
        }
    }

}