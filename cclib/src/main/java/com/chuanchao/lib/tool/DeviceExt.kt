package com.chuanchao.lib.tool

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import android.telephony.TelephonyManager

/**
 *
 * Author: chuanchao
 * Data: 2019-12-30
 * Desc: 读取设备信息扩展类
 *
 */


/**
 * 获取IMEI（国际移动设备身份码）
 * 有电话功能的移动设备才具有，双卡手机有两个IMEI
 *
 * 需要权限
 * `<uses-permission android:name = "android.permission.READ_PHONE_STATE" />`
 */
@SuppressLint("MissingPermission")
fun Context.getImei(): String {
    val tm = this.applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        tm.imei
    } else {
        tm.deviceId
    }

}


/**
 * 获取IMSI（国际移动设备识别码）
 *
 * 需要权限
 * `<uses-permission android:name = "android.permission.READ_PHONE_STATE" />`
 */
@SuppressLint("MissingPermission")
fun Context.getImsi(): String {
    val tm = this.applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return tm.subscriberId
}


/**
 * 获取Mac地址，在手机开机后要打开过一次Wifi才能获取到Mac地址
 *
 * 需要权限
 * `<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />`
 */
@SuppressLint("MissingPermission")
fun Context.getMacAddress(): String {
    val wm = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    return wm.connectionInfo.macAddress
}
