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
class ChangFengMapsmall(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
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
            //煤2
            canvas?.drawLine(
                    50F/beishu,
                    400F/beishu,
                    1000F/beishu,
                    400F/beishu,
                    mPaint
            )
            canvas?.drawText("煤2", 10F/beishu,400F/beishu, paint)
            canvas?.drawText("北川煤场", 10F/beishu,450F/beishu, paint)
            //煤1
            canvas?.drawLine(
                    450F/beishu,
                    400F/beishu,
                    350F/beishu,
                    500F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    350F/beishu,
                    500F/beishu,
                    50F/beishu,
                    500F/beishu,
                    mPaint
            )
            canvas?.drawText("煤1", 10F/beishu,500F/beishu, paint)
            //长丰专用线
                canvas?.drawLine(
                        800F/beishu,
                        400F/beishu,
                        700F/beishu,
                        500F/beishu,
                        mPaint
                )
            canvas?.drawLine(
                    700F/beishu,
                    500F/beishu,
                    500F/beishu,
                    500F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    700F/beishu,
                    500F/beishu,
                    1000F/beishu,
                    500F/beishu,
                    mPaint
            )
            canvas?.drawText("长丰专用线", 500F/beishu,520F/beishu, paint)
            //园1
            canvas?.drawLine(
                    600F/beishu,
                    400F/beishu,
                    550F/beishu,
                    300F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    550F/beishu,
                    300F/beishu,
                    50F/beishu,
                    300F/beishu,
                    mPaint
            )
            canvas?.drawText("物流专用线", 10F/beishu,250F/beishu, paint)
            canvas?.drawText("园1", 400F/beishu,320F/beishu, paint)
            //园2
            canvas?.drawLine(
                    500F/beishu,
                    300F/beishu,
                    450F/beishu,
                    200F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    450F/beishu,
                    200F/beishu,
                    150F/beishu,
                    200F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    150F/beishu,
                    200F/beishu,
                    100F/beishu,
                    300F/beishu,
                    mPaint
            )
            canvas?.drawText("园2", 400F/beishu,220F/beishu, paint)

            //道口
            canvas?.drawText("道口", 240F/beishu,180F/beishu, paint)
            canvas?.drawLine(
                    250F/beishu,
                    190F/beishu,
                    240F/beishu,
                    180F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    250F/beishu,
                    310F/beishu,
                    240F/beishu,
                    320F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    250F/beishu,
                    190F/beishu,
                    250F/beishu,
                    310F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    270F/beishu,
                    190F/beishu,
                    280F/beishu,
                    180F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    270F/beishu,
                    310F/beishu,
                    280F/beishu,
                    320F/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    270F/beishu,
                    190F/beishu,
                    270F/beishu,
                    310F/beishu,
                    mPaint
            )
        }
    }
}