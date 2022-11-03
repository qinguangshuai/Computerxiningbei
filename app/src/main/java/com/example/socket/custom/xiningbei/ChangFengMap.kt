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
class ChangFengMap(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val mPaint by lazy {
        Paint().also {
            it.color = Color.parseColor("#000000")
            it.style = Paint.Style.FILL
            it.isAntiAlias = true
            it.strokeWidth = 3F
            it.isDither = true
        }
    }

    private val paint by lazy {
        Paint().also {
            it.color = Color.parseColor("#FF0000")
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
            //煤2
            canvas?.drawLine(
                    50F,
                    400F,
                    1000F,
                    400F,
                    mPaint
            )
            canvas?.drawText("煤2", 10F,400F, paint)
            canvas?.drawText("北川煤场", 10F,450F, paint)
            //煤1
            canvas?.drawLine(
                    450F,
                    400F,
                    350F,
                    500F,
                    mPaint
            )
            canvas?.drawLine(
                    350F,
                    500F,
                    50F,
                    500F,
                    mPaint
            )
            canvas?.drawText("煤1", 10F,500F, paint)
            //长丰专用线
                canvas?.drawLine(
                        800F,
                        400F,
                        700F,
                        500F,
                        mPaint
                )
            canvas?.drawLine(
                    700F,
                    500F,
                    500F,
                    500F,
                    mPaint
            )
            canvas?.drawLine(
                    700F,
                    500F,
                    1000F,
                    500F,
                    mPaint
            )
            canvas?.drawText("长丰专用线", 500F,520F, paint)
            //园1
            canvas?.drawLine(
                    600F,
                    400F,
                    550F,
                    300F,
                    mPaint
            )
            canvas?.drawLine(
                    550F,
                    300F,
                    50F,
                    300F,
                    mPaint
            )
            canvas?.drawText("物流专用线", 10F,250F, paint)
            canvas?.drawText("园1", 400F,320F, paint)
            //园2
            canvas?.drawLine(
                    500F,
                    300F,
                    450F,
                    200F,
                    mPaint
            )
            canvas?.drawLine(
                    450F,
                    200F,
                    150F,
                    200F,
                    mPaint
            )
            canvas?.drawLine(
                    150F,
                    200F,
                    100F,
                    300F,
                    mPaint
            )
            canvas?.drawText("园2", 400F,220F, paint)

            //道口
            canvas?.drawText("道口", 240F,180F, paint)
            canvas?.drawLine(
                    250F,
                    190F,
                    240F,
                    180F,
                    mPaint
            )
            canvas?.drawLine(
                    250F,
                    310F,
                    240F,
                    320F,
                    mPaint
            )
            canvas?.drawLine(
                    250F,
                    190F,
                    250F,
                    310F,
                    mPaint
            )
            canvas?.drawLine(
                    270F,
                    190F,
                    280F,
                    180F,
                    mPaint
            )
            canvas?.drawLine(
                    270F,
                    310F,
                    280F,
                    320F,
                    mPaint
            )
            canvas?.drawLine(
                    270F,
                    190F,
                    270F,
                    310F,
                    mPaint
            )
        }
    }
}