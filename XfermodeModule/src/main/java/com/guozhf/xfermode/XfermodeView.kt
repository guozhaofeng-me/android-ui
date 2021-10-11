package com.guozhf.xfermode

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * created by zephyr on 10/11/21 17 : 37
 */
internal class XfermodeView : View {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context?) {

    }

}