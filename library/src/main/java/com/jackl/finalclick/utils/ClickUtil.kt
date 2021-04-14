package com.jackl.finalclick.utils

import android.view.View

object ClickUtil {

    private var intervalMillis=2000

    /**
     * 最近一次点击的时间
     */
    private var mLastClickTime: Long = 0

    /**
     * 最近一次点击的控件ID
     */
    private var mLastClickViewId = 0

    /**
     * 是否是快速点击
     * @return  true:是，false:不是
     */
    fun isFastClick(v: View): Boolean {
        val viewId: Int = v.getId()
        val time = System.currentTimeMillis()
        val timeInterval = Math.abs(time - mLastClickTime)
        return if (timeInterval < intervalMillis && viewId == mLastClickViewId) {
            true
        } else {
            mLastClickTime = time
            mLastClickViewId = viewId
            false
        }
    }
}