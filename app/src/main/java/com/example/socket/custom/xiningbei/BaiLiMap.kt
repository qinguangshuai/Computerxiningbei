package com.example.socket.custom.xiningbei

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
class BaiLiMap(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

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
            it.color = Color.parseColor("#70A6EE")
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
                    50F,
                    300F,
                    500F,
                    550F,
                    mPaint
            )
            canvas?.drawLine(
                    500F,
                    550F,
                    800F,
                    550F,
                    mPaint
            )
            canvas?.drawText("百立专用线", 550F,545F, paint)
            //物资局专用线
            canvas?.drawLine(
                    50F,
                    150F,
                    150F,
                    150F,
                    mPaint
            )
            //斜线
            canvas?.drawLine(
                    150F,
                    150F,
                    400F,
                    350F,
                    mPaint
            )
            //物2
            canvas?.drawLine(
                    400F,
                    350F,
                    1000F,
                    350F,
                    mPaint
            )
            canvas?.drawText("物2", 700F,370F, paint)
            //直线
            canvas?.drawLine(
                    550F,
                    450F,
                    900F,
                    450F,
                    mPaint
            )
            canvas?.drawLine(
                    450F,
                    350F,
                    550F,
                    450F,
                    mPaint
            )
            canvas?.drawText("物1", 700F,470F, paint)
            //直线
            canvas?.drawLine(
                    550F,
                    250F,
                    750F,
                    250F,
                    mPaint
            )
            canvas?.drawLine(
                    500F,
                    350F,
                    550F,
                    250F,
                    mPaint
            )
            canvas?.drawLine(
                    750F,
                    250F,
                    800F,
                    350F,
                    mPaint
            )
            canvas?.drawText("物3", 700F,270F, paint)
        }
    }
}