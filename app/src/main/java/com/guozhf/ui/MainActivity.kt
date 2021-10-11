package com.guozhf.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.guozhf.xfermode.XfermodeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * 跳转到Xfermode相关知识页面
     */
    fun onXfermodeClick(view: View) {
        XfermodeActivity.start(this)
    }
}