package com.guozhf.xfermode

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.library.flowlayout.FlowLayoutManager
import com.library.flowlayout.SpaceItemDecoration
import comguozhfxfermode.Mode

class XfermodeActivity : AppCompatActivity() {
    private val list: List<PorterDuff.Mode> by lazy {
        val list = mutableListOf<PorterDuff.Mode>()
        list.add(PorterDuff.Mode.CLEAR)
        list.add(PorterDuff.Mode.SRC)
        list.add(PorterDuff.Mode.DST)
        list.add(PorterDuff.Mode.SRC_OVER)
        list.add(PorterDuff.Mode.DST_OVER)
        list.add(PorterDuff.Mode.SRC_IN)
        list.add(PorterDuff.Mode.DST_IN)
        list.add(PorterDuff.Mode.SRC_OUT)
        list.add(PorterDuff.Mode.DST_OUT)
        list.add(PorterDuff.Mode.SRC_ATOP)
        list.add(PorterDuff.Mode.DST_ATOP)
        list.add(PorterDuff.Mode.XOR)
        list.add(PorterDuff.Mode.DARKEN)
        list.add(PorterDuff.Mode.LIGHTEN)
        list.add(PorterDuff.Mode.MULTIPLY)
        list.add(PorterDuff.Mode.SCREEN)
        list.add(PorterDuff.Mode.ADD)
        list.add(PorterDuff.Mode.OVERLAY)
        list
    }

    private val consoleAdapter: XfermodeAdapter by lazy {
        val adapter = XfermodeAdapter(list)
        adapter.onClickListener = onConsoleListener
        adapter
    }

    private var onConsoleListener: ((PorterDuff.Mode) -> Unit) = {
        Toast.makeText(this, "item clicked: $it", Toast.LENGTH_SHORT).show()
        xfermodeView.setMode(it)
    }

    private lateinit var xfermodeView: XfermodeView

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
            layoutManager = FlowLayoutManager()
            addItemDecoration(SpaceItemDecoration(30));
        }
        xfermodeView = findViewById<XfermodeView>(R.id.xfermode_view)
    }

}