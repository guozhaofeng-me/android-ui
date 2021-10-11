package com.guozhf.xfermode

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import comguozhfxfermode.Mode

class XfermodeActivity : AppCompatActivity() {
    private val list: List<String> by lazy {
        val list = mutableListOf<String>()
        list.add(Mode.ADD.toString())
        list.add(Mode.CLEAR.toString())
        list.add(Mode.DARKEN.toString())
        list.add(Mode.DST.toString())
        list
    }

    private val consoleAdapter: XfermodeAdapter by lazy {
        val adapter = XfermodeAdapter(list)
        adapter.onClickListener = onConsoleListener
        adapter
    }

    private var mode: String? = null

    private var onConsoleListener: ((String) -> Unit) = {
        Toast.makeText(this, "item clicked: $it", Toast.LENGTH_SHORT).show()
        mode = it
    }

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, XfermodeActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xfermode)
        val rvConsole = findViewById<RecyclerView>(R.id.console)
        rvConsole.apply {
            adapter = consoleAdapter
            layoutManager = GridLayoutManager(this@XfermodeActivity, 5)
        }
    }

}