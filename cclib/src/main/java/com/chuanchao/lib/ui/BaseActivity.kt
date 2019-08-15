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
abstract class BaseActivity : AppCompatActivity(), ILayout, ILoading {


    /**
     * dialo加载框,不用byLazy为了避免不必要的初始化
     */
    private var loadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        initLayout()
        initData()
    }


    override fun showLoading() {

        when(loadingBy()){
            ILoading.LoadingBY.DIALOG -> {
                if(loadingDialog==null){
                    loadingDialog = LoadingDialog.loadingDialog(this@BaseActivity)
                }
                loadingDialog?.show()
            }
            ILoading.LoadingBY.SMART_REFRESH ->{

            }
        }

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun loadingView(): View? {

        if(ILoading.LoadingBY.DIALOG ==loadingBy()){
            return  null
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