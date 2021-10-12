package com.guozhf.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * created by zephyr on 10/11/21 17 : 37
 */
class XfermodeView : View {
    private val _width: Float = 500F
    private val _height: Float = 500F
    private var dstBmp: Bitmap? = null
    private var srcBmp: Bitmap? = null
    private val paint: Paint by lazy {
        val p = Paint()
        p.isAntiAlias = true
        p
    }
    private var mode: PorterDuff.Mode? = PorterDuff.Mode.CLEAR

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    private fun init(context: Context?) {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        dstBmp = makeDstBmp(_width, _height)
        srcBmp = makeSrcBmp(_width, _height)
    }

    override fun onDraw(canvas: Canvas?) {
        val layerId = canvas!!.saveLayer(
            0F, 0F, _width * 2,
            _height * 2, paint, Canvas.ALL_SAVE_FLAG
        )
        canvas.drawBitmap(dstBmp!!, 0F, 0F, paint)
        paint.xfermode = PorterDuffXfermode(mode)
        canvas.drawBitmap(srcBmp!!, _width / 2, _height / 2, paint)
        paint.xfermode = null
        canvas.restoreToCount(layerId)
    }

    private fun makeDstBmp(w: Float, h: Float): Bitmap {
        val dstBmp = Bitmap.createBitmap(w.toInt(), h.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(dstBmp)
        val p = Paint()
        p.isAntiAlias = true
        p.color = Color.RED
        canvas.drawOval(RectF(0F, 0F, w, h), p)
        p.color = Color.WHITE
        p.textSize = 50F
        p.strokeWidth = 10F
        canvas.drawText("DstBmp", w / 2, h / 2, p)
        return dstBmp
    }

    private fun makeSrcBmp(w: Float, h: Float): Bitmap {
        val dstBmp = Bitmap.createBitmap(w.toInt(), h.toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(dstBmp)
        val p = Paint()
        p.isAntiAlias = true
        p.color = Color.GREEN
        canvas.drawRect(0F, 0F, w, h, p)
        p.color = Color.WHITE
        p.textSize = 50F
        p.strokeWidth = 10F
        canvas.drawText("SrcBmp", w / 2, h / 2, p)
        return dstBmp
    }

    fun setMode(mode: PorterDuff.Mode) {
        this.mode = mode
        invalidate()
    }


}