package com.jackl.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jackl.finalclick.Extension.needQuickClick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        val TAG = "log_jackl"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //对button2，button4，button5禁用防快速点击
        button2.needQuickClick()
        button4.needQuickClick()
        button5.needQuickClick()

        button1.setOnClickListener {
            Log.d(TAG,"点击了tutton1")
        }

        button2.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(TAG,"点击了tutton2")
            }

        })
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        initRecycleView()
    }

    private fun initRecycleView() {
        val list = arrayListOf<String>()
        list.add("recyclebutton1")
        list.add("recyclebutton2")
        list.add("recyclebutton3")
        recyclerView.layoutManager=LinearLayoutManager(this)
        val recyclerAdapter = RecyclerAdapter(list)
        recyclerView.adapter=recyclerAdapter
        recyclerAdapter.mListener={
            Log.d(TAG,"点击了{$it}")
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button3->{
                Log.d(TAG,"点击了tutton3")
            }

            R.id.button4->{
                Log.d(TAG,"点击了tutton4")
            }

            R.id.button5->{
                Log.d(TAG,"点击了tutton5")
            }
        }
    }


}