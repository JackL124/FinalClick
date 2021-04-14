package com.jackl.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackl.finalclick.Extension.needQuickClick
import kotlinx.android.synthetic.main.item.view.*

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.MyTVHolder>() {
    var mylist= arrayListOf<String>()
    var mListener : ((String) -> Unit) ?=null
    constructor(list :ArrayList<String>) : this() {
        mylist=list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTVHolder {
        return MyTVHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onBindViewHolder(holder: MyTVHolder, position: Int) {
        holder.itemView.button.setText(mylist.get(position))
        //对偶数位置button 禁用防止快速点击
        if(position%2==0){
            holder.itemView.button.needQuickClick()
        }
        holder.itemView.button.setOnClickListener {
            mListener?.invoke(mylist.get(position))
        }
    }

     class MyTVHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}