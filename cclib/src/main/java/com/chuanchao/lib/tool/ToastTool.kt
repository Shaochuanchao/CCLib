package com.chuanchao.lib.tool

import android.content.Context
import android.widget.Toast
import com.chuanchao.lib.BaseApp

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: toast扩展函数
 *
 */


/**
 *  "hello".toast()
 */
fun String?.toast() {

    if (this == null) {
        return
    }

    BaseApp.instance().toast(this)
}

/**
 * context.toast("hello")
 */
fun Context.toast(message: String) {
    if (message.isBlank()) {
        return
    }
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}