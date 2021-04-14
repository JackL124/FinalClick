package com.jackl.finalpermission.aspect

import android.view.View
import com.jackl.finalclick.Extension.isNeedQuickClick
import com.jackl.finalclick.utils.ClickUtil
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut



/**
 * 切面类 防快速点击
 * Created jackl on 2021/4/13
 */
@Aspect
class ClickAspect {

    /**
     *正常点击事件切点
     * */
    @Pointcut("execution(* android.view.View.OnClickListener.onClick(..))")
    fun clickPointcut() {

    }

    /**
     *lambda点击事件切点
     * */
    @Pointcut("execution(* com.packagename..lambda*(android.view.View))")
    fun lambdaClickPointcut() {
    }

    /**
     *xml点击事件切点
     * */
    @Pointcut("execution(* androidx.appcompat.app.AppCompatViewInflater.DeclaredOnClickListener.onClick(..))")
    fun xmlClickPointcut() {
    }

//    /**
//     * 不需要防快速点击
//     * */
//    @Pointcut("execution(@com.jackl.finalpermission.annotation.NeedQuickClick  * *(..))")
//    fun NeedQuickClickPointcut() {
//    }

    /**
     * 环绕织入，在被注解标记的目标切入点函数执行前处理快速点击
     * */
    @Around("clickPointcut() || lambdaClickPointcut() || xmlClickPointcut()")
    fun AroundAdvice(joinPoint: ProceedingJoinPoint) {
        var view: View? = joinPoint.args[0] as View
        if(view==null){
            return
        }
//        val methodSignature = joinPoint.signature as MethodSignature
//        val method: Method = methodSignature.method
//        val needQuickClick: NeedQuickClick? =if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            method.getDeclaredAnnotation(NeedQuickClick::class.java)
//        } else {
//            null
//        }
        if (view.isNeedQuickClick()){
            joinPoint.proceed()
        }else if(!ClickUtil.isFastClick(view)){
            joinPoint.proceed()
        }
        return
    }
}