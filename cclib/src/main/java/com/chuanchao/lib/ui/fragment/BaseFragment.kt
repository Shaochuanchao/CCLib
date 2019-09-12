package com.chuanchao.lib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chuanchao.lib.ui.ILayout
import com.chuanchao.lib.ui.ILoading
import com.chuanchao.lib.ui.activity.BaseActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout

/**
 *
 * Author: chuanchao
 * Data: 2019-09-12
 * Desc: //TODO
 *
 */
abstract class BaseFragment : Fragment(), ILayout, ILoading {

    lateinit var smartRefreshLayout: SmartRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(getLayoutResId(), null)
        if (isNeedSmartRefresh()) {
            smartRefreshLayout = SmartRefreshLayout(activity).apply {
                addView(
                    view,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
            }
            return smartRefreshLayout
        }

        return view
    }



    override fun hideLoading() {
        when (loadingBy()) {
            ILoading.LoadingBY.DIALOG -> (activity as BaseActivity).showLoading()
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



}