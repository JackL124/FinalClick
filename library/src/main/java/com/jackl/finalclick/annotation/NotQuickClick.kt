package com.jackl.finalpermission.annotation

import androidx.annotation.IdRes
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * 权限申请注解
 * Created jackl on 2021/4/13
 * @param tagetViewId 不需要快速点击的viewid
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

annotation class NeedQuickClick(
    @IdRes vararg val tagetViewIds:Int
)