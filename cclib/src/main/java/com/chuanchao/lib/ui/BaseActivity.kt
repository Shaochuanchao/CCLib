package com.chuanchao.lib.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chuanchao.lib.ui.widget.LoadingDialog

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: activity 基类
 *
 */
abstract class BaseActivity : AppCompatActivity(), ILayout, ILoading, IState {


    /**
     * dialo加载框
     */
    val loadingDialg: LoadingDialog by lazy {
        LoadingDialog.loadingDialog(this)
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        initLayout()
        initData()
    }


    override fun showLoading() {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun loadingView(): View {

//        val loadingView = when (loadingBy()) {
//            ILoading.LoadingBY.CUTOM_VIEW -> loadingView()
//            ILoading.LoadingBY.SMART_REFRESH ->
//
//        }
        return loadingView()
    }

}