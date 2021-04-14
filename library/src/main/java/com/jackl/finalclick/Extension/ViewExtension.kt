package com.jackl.finalclick.Extension

import android.view.View

fun View.needQuickClick(){
  this.setTag(this.id,true)
}

fun View.isNeedQuickClick(): Boolean{
  if(this.getTag(this.id) is Boolean){
    return this.getTag(this.id) as Boolean
  }
  return false
}