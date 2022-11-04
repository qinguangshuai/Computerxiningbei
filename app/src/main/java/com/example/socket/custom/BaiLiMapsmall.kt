package com.example.socket.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * @date   2021/3/19 11:00
 */
class BaiLiMapsmall(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val beishu =  1.7F
    private val mPaint by lazy {
        Paint().also {
            it.color = Color.parseColor("#70A6EE")
            it.style = Paint.Style.FILL
            it.isAntiAlias = true
            it.strokeWidth = 3F
            it.isDither = true
        }
    }

    private val paint by lazy {
        Paint().also {
            it.color = Color.parseColor("#70A6EE")
            it.style = Paint.Style.FILL
            it.isAntiAlias = true
            it.strokeWidth = 1F
            it.textSize = 20F
            it.isDither = true
        }
    }
    private val paint1 by lazy {
        Paint().also {
            it.color = Color.parseColor("#625B5B")
            it.style = Paint.Style.FILL
            it.isAntiAlias = true
            it.strokeWidth = 3F
            it.textSize = 18F
            it.isDither = true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = canvas?.width
        val height = canvas?.height
        Log.e("name", width.toString() + "  width  ")
        Log.e("name", height.toString() + "  height  ")
        if (height != null && width != null) {
            //百立专用线
            canvas?.drawLine(
                    50F/beishu,
                    300F/beishu,
                    500F/beishu,
                    550F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    500F/beishu,
                    550F/beishu,
                    800F/beishu,
                    550F/beishu,
                    mPaint
            )
            canvas?.drawText("百立专用线", 550F/beishu,530F/beishu, paint)
            //物资局专用线
            canvas?.drawLine(
                    50F/beishu,
                    150F/beishu,
                    150F/beishu,
                    150F/beishu,
                    mPaint
            )
            //斜线
            canvas?.drawLine(
                    150F/beishu,
                    150F/beishu,
                    400F/beishu,
                    350F/beishu,
                    mPaint
            )
            //物2
            canvas?.drawLine(
                    400F/beishu,
                    350F/beishu,
                    1000F/beishu,
                    350F/beishu,
                    mPaint
            )
            canvas?.drawText("物2", 700F/beishu,370F/beishu, paint)
            //直线
            canvas?.drawLine(
                    550F/beishu,
                    450F/beishu,
                    900F/beishu,
                    450F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    450F/beishu,
                    350F/beishu,
                    550F/beishu,
                    450F/beishu,
                    mPaint
            )
            canvas?.drawText("物1", 700F/beishu,470F/beishu, paint)
            //直线
            canvas?.drawLine(
                    550F/beishu,
                    250F/beishu,
                    750F/beishu,
                    250F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    500F/beishu,
                    350F/beishu,
                    550F/beishu,
                    250F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    750F/beishu,
                    250F/beishu,
                    800F/beishu,
                    350F/beishu,
                    mPaint
            )
            canvas?.drawText("物3", 700F/beishu,270F/beishu, paint)
        }
    }
}