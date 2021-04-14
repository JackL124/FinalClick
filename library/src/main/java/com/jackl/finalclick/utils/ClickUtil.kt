package com.jackl.finalclick.utils

import android.view.View

object ClickUtil {

    private var intervalMillis=2000

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
    fun isFastClick(v: View): Boolean {
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