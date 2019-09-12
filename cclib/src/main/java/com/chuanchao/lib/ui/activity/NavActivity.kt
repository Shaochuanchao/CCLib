package com.chuanchao.lib.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.chuanchao.lib.R
import com.chuanchao.lib.ui.INav

/**
 *
 * Author: chuanchao
 * Data: 2019-08-19
 * Desc: toolbar - 导航基类定义
 *
 */
open class NavActivity : AppCompatActivity(), INav {


    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportActionBar != null) {
            initToolbar()
        }

    }

    private fun initToolbar() {

        toolbar = Toolbar(this).apply {
            setPadding(0, 0, 0, 0)
            setContentInsetsAbsolute(0, 0)
            contentInsetStartWithNavigation = 0
            setNavigationIcon(backDrawableId())

        }
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(showBackIcon())
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun backDrawableId() = R.drawable.action_back

    override fun showBackIcon() = !isTaskRoot


}