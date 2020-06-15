package com.chuanchao.lib.tool

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

/**
 *
 * Author: chuanchao
 * Data: 2020/6/15
 * Desc: 其他帮助类
 *
 */


/**
 * 方法太多的interface，只需要其中几个的时候用
 */
inline fun <reified T : Any> noOpDelegate(): T {
    val javaClass = T::class.java
    val noOpHandler = InvocationHandler { _, _, _ ->
        // no op
    }
    return Proxy.newProxyInstance(
        javaClass.classLoader, arrayOf(javaClass), noOpHandler
    ) as T
}



