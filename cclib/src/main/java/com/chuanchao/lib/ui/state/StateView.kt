package com.chuanchao.lib.ui.state

import android.view.View
import com.chuanchao.lib.ui.ILoading

/**
 *
 * Author: chuanchao
 * Data: 2019-08-14
 * Desc: viewBuilder
 *
 */
class StateView private constructor(
    val dataView: View, val emptyView: View? = null,
    val errorView: View? = null, val loadingView: View? = null,
    val loadingBy: ILoading.LoadingBY? = null
) {

    /**
     * builder
     */
    data class Builder(
        var dataView: View , var emptyView: View? = null,
        var errorView: View? = null, var loadingView: View? = null,
        var loadingBy: ILoading.LoadingBY? = null
    ) {

        /**
         * 数据展示
         */
        fun dateView(dataView: View) = apply {
            this.dataView = dataView
        }

        fun emptyView(emptyView: View) = apply {
            this.emptyView = emptyView
        }

        fun errorView(errorView: View) = apply {
            this.errorView = errorView
        }

        fun loadingView(loadingView: View) = apply {
            this.loadingView = loadingView
        }

        fun loadingBy(loadingBY: ILoading.LoadingBY) = apply {
            this.loadingBy = loadingBY
        }


        fun build() {


        }

    }


}