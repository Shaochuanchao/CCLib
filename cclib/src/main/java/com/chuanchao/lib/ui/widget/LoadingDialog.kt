package com.chuanchao.lib.ui.widget

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import com.chuanchao.lib.R

/**
 *
 * Author: chuanchao
 * Data: 2019-08-13
 * Desc: 加载框(现在很少采用Dialog形式的加载形式，除非有刚需--需要用户等待处理完成后才能操作)
 *
 */
class LoadingDialog(context: Context, theme: Int) : Dialog(context, theme) {

    companion object {

        fun loadingDialog(content: Context): LoadingDialog {
            val dialog = LoadingDialog(content, R.style.Dialog_No_Border)
            dialog.window?.attributes?.gravity = Gravity.CENTER
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.custom_dialog)

            return dialog
        }

    }

}