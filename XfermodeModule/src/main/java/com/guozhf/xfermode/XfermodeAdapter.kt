package com.guozhf.xfermode

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * created by zephyr on 10/11/21 17 : 06
 *
 */
class XfermodeAdapter(private val list: List<String>) : RecyclerView.Adapter<XfermodeAdapter.VH>() {

    private val statusMap: SparseArray<Boolean> by lazy {
        val sa = SparseArray<Boolean>()
        list.forEachIndexed { index, _ ->
            sa.put(index, false)
        }
        sa
    }

    var onClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_xfermode, parent, false)
        return VH(layout)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val tvMode: TextView = itemView.findViewById(R.id.tv_mode)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(position: Int) {
            tvMode.text = list[position]
            itemView.tag = position
        }

        override fun onClick(v: View?) {
            onClickListener?.let { onClick ->
                onClick(list[v?.tag as Int])
            }
        }
    }
}