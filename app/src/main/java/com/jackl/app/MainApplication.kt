package com.jackl.app

import android.app.Application
import com.jackl.finalclick.utils.ClickUtil

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        ClickUtil.intervalMillis=500
    }

}
