package com.chuanchao.lib.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.chuanchao.lib.ui.widget.loading.DefaultLoadingImpl
import com.chuanchao.lib.ui.widget.loading.ILoading

/**
 *
 * Author: chuanchao
 * Data: 2020/6/15
 * Desc: fragment加载逻辑处理
 *
 */
open class LoadingFragment : Fragment(), ILoading {

    private lateinit var loadingImpl: DefaultLoadingImpl


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
            requireContext(),
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