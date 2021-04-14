package com.jackl.finalclick.utils

import android.view.View

/**
 * 快速点击工具类
 * Created jackl on 2021/4/13
 */

object ClickUtil {

    /**
     * 间隔时间
     * */
    var intervalMillis=500

    /**
     * 最近一次点击的时间
     */
    private var mLastClickTime: Long = 0

    /**
     * 最近一次点击的控件的hashcode
     */
    private var mLastClickViewCode = 0

    /**
     * 是否是快速点击
     * @return  true:是，false:不是
     */
    internal fun isFastClick(v: View): Boolean {
        val viewCode: Int = v.hashCode()
        val time = System.currentTimeMillis()
        val timeInterval = Math.abs(time - mLastClickTime)
        return if (timeInterval < intervalMillis && viewCode == mLastClickViewCode) {
            true
        } else {
            mLastClickTime = time
            mLastClickViewCode = viewCode
            false
        }
    }
}