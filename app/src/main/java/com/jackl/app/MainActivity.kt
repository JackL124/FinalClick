package com.jackl.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.jackl.finalpermission.annotation.NeedQuickClick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        val TAG = "log_jackl"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
            Log.d(TAG,"点击了tutton1")
        }


        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }

    @NeedQuickClick(R.id.button2,R.id.button3)
    override fun onClick(v: View) {
        when(v.id){
            R.id.button2->{
                Log.d(TAG,"点击了tutton2")
            }

            R.id.button3->{
                Log.d(TAG,"点击了tutton3")
            }
        }
    }


}