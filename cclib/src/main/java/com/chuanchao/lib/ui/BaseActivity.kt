package com.chuanchao.lib.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: activity 基类
 *
 */
abstract class BaseActivity : AppCompatActivity(), ILayout, ILoading, IState {


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


}