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
class XiNingBeiMapsmall(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

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
            it.textSize = 18F
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
            //H3
            canvas?.drawLine(
                    (canvas.width / 8 * 2.4).toFloat(),
                    height.toFloat() / 12 * 1,
                    canvas.width.toFloat() / 8 * 6,
                    height.toFloat() / 12 * 1,
                    mPaint
            )
            //左斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 2.4).toFloat(),
                    height.toFloat() / 12 * 1,
                    (canvas.width / 8 * 1.8).toFloat(),
                    height.toFloat() / 12 * 3,
                    mPaint
            )
            //右斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 5).toFloat(),
                    height.toFloat() / 12 * 1,
                    canvas.width.toFloat() / 8 * 6,
                    height.toFloat() / 12 * 3,
                    mPaint
            )
            canvas?.drawText("H3", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 1 + 15, paint)
            //H2
            canvas?.drawLine(
                    (canvas.width / 8 * 1.6).toFloat(),
                    height.toFloat() / 12 * 3,
                    canvas.width.toFloat() / 8 * 6,
                    height.toFloat() / 12 * 3,
                    mPaint
            )
            Log.e("qgs1", (canvas.width / 8 * 1.6).toFloat().toString())
            Log.e("qgs2", (height.toFloat() / 12 * 3).toString())
            //左斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 1.6).toFloat(), height.toFloat() / 12 * 3,
                    (canvas.width / 8).toFloat(), height.toFloat() / 12 * 5, mPaint
            )
            Log.e("qgs3", (canvas.width / 8).toFloat().toString())
            Log.e("qgs4", (height.toFloat() / 12 * 5).toString())
            //右斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 6).toFloat(), height.toFloat() / 12 * 3, (canvas.width / 8 * 6.5).toFloat(),
                    (height.toFloat() / 12 * 6.5).toFloat(), mPaint
            )
            canvas?.drawText("H2", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 3 + 15, paint)
            //H1
            canvas?.drawLine(
                    50F,
                    height.toFloat() / 12 * 5,
                    canvas.width.toFloat() / 8 * 6,
                    height.toFloat() / 12 * 5,
                    mPaint
            )
            Log.e("qgs3", (height.toFloat() / 12 * 5).toString())
            //右斜线
            canvas?.drawLine(
                    canvas.width.toFloat() / 8 * 6,
                    height.toFloat() / 12 * 5,
                    canvas.width.toFloat() / 8 * 7,
                    height.toFloat() / 12 * 8,
                    mPaint
            )
            canvas?.drawText("H1", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 5 + 15, paint)
            //5
            canvas?.drawLine(
                    (canvas.width / 8 * 3).toFloat(),
                    height.toFloat() / 12 * 6,
                    (canvas.width / 8 * 5).toFloat(),
                    height.toFloat() / 12 * 6,
                    mPaint
            )
            //左斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 2).toFloat(),
                    height.toFloat() / 12 * 8,
                    (canvas.width / 8 * 3).toFloat(),
                    height.toFloat() / 12 * 6,
                    mPaint
            )
            canvas?.drawText("5", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 6 + 15, paint)
            //右斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 5).toFloat(),
                    height.toFloat() / 12 * 6,
                    (canvas.width / 8 * 6).toFloat(),
                    height.toFloat() / 12 * 8,
                    mPaint
            )
            //4
            canvas?.drawLine(
                    (canvas.width / 8 * 2.5).toFloat(),
                    height.toFloat() / 12 * 7,
                    (canvas.width / 8 * 5.5).toFloat(),
                    height.toFloat() / 12 * 7,
                    mPaint
            )
            canvas?.drawText("4", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 7 + 15, paint)
            //III
            canvas?.drawLine(
                    (canvas.width / 8).toFloat(),
                    height.toFloat() / 12 * 8,
                    canvas.width.toFloat() - 50,
                    height.toFloat() / 12 * 8,
                    mPaint
            )
            //左斜线
            canvas?.drawLine(
                    50F,
                    height.toFloat() / 12 * 5,
                    (canvas.width / 8).toFloat(),
                    height.toFloat() / 12 * 8,
                    mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 1.5).toFloat(),
                    height.toFloat() / 12 * 8,
                    (canvas.width / 8 * 2).toFloat(),
                    height.toFloat() / 12 * 9,
                    mPaint
            )
            canvas?.drawText("III", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 8 + 15, paint)
            //2
            canvas?.drawLine(
                    50F,
                    height.toFloat() / 12 * 9,
                    (canvas.width / 8 * 6).toFloat(),//450
                    height.toFloat() / 12 * 9,//768
                    mPaint
            )
            //右斜线(canvas.width/8*6.5).toFloat()=832.0   (canvas.width/8*6).toFloat()=768.0
            //height.toFloat()/12*10=439.1667     height.toFloat()/12*9=395.25
            canvas?.drawLine(
                    (canvas.width / 8 * 6).toFloat(), height.toFloat() / 12 * 9,
                    (canvas.width / 8 * 6.5).toFloat(), height.toFloat() / 12 * 10, mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 7).toFloat(),
                    height.toFloat() / 12 * 10,
                    (canvas.width / 8 * 7.2).toFloat(),
                    height.toFloat() / 12 * 9,
                    mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 7.2).toFloat(), height.toFloat() / 12 * 9,
                    (canvas.width - 50).toFloat(), height.toFloat() / 12 * 9, mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 6.5).toFloat(), height.toFloat() / 12 * 10,
                    (canvas.width - 50).toFloat(), height.toFloat() / 12 * 10, mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 6.7).toFloat(), height.toFloat() / 12 * 10,
                    (canvas.width / 8 * 7).toFloat(), height.toFloat() / 12 * 11, mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 7).toFloat(), height.toFloat() / 12 * 11,
                    (canvas.width - 50).toFloat(), height.toFloat() / 12 * 11, mPaint
            )
            canvas?.drawText("2", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 9 + 15, paint)
            canvas?.drawText("物1", (canvas.width / 8 * 7.2).toFloat(), height.toFloat() / 12 * 9 + 15, paint)
            canvas?.drawText("物2", (canvas.width / 8 * 7).toFloat(), height.toFloat() / 12 * 10 + 15, paint)
            canvas?.drawText("物3", (canvas.width / 8 * 7).toFloat(), height.toFloat() / 12 * 11 + 15, paint)
            //1
            canvas?.drawLine(
                    width.toFloat() / 8 * 3,
                    height.toFloat() / 12 * 10,
                    width.toFloat() / 8 * 5,
                    height.toFloat() / 12 * 10,
                    mPaint
            )
            //左斜线 width 384.0    320.0
            canvas?.drawLine(
                    width.toFloat() / 8 * 3,
                    height.toFloat() / 12 * 10,
                    (width.toFloat() / 8 * 2.5).toFloat(),
                    height.toFloat() / 12 * 9,
                    mPaint
            )
            //长丰专用线    192.0
            canvas?.drawLine(
                    50F,
                    height.toFloat() / 12 * 10,
                    (width.toFloat() / 8 * 1.5).toFloat(),
                    height.toFloat() / 12 * 10,
                    mPaint
            )
            canvas?.drawText("长丰专用线", (width.toFloat() / 8).toFloat(), height.toFloat() / 12 * 10 + 15, paint)
            //1道中间  width ((width.toFloat()/8*1.5).toFloat() = 192.0     width.toFloat()/8*12 = 256.0)
            canvas?.drawLine(
                    (width.toFloat() / 8 * 1.5).toFloat(),
                    height.toFloat() / 12 * 9,
                    width.toFloat() / 8 * 2,
                    height.toFloat() / 12 * 10,
                    mPaint
            )
            //(width.toFloat()/8*2.5).toFloat() = 256.0
            canvas?.drawLine(
                    width.toFloat() / 8 * 2,
                    height.toFloat() / 12 * 10,
                    (width.toFloat() / 8 * 2.5).toFloat(),
                    height.toFloat() / 12 * 10,
                    mPaint
            )
            //(width.toFloat()/8*1.5).toFloat() = 192.0    (width.toFloat()/8*1.3).toFloat() = 166.4
            canvas?.drawLine(
                    (width.toFloat() / 8 * 1.3).toFloat(),
                    height.toFloat() / 12 * 9,
                    width.toFloat() / 8,
                    height.toFloat() / 12 * 10,
                    mPaint
            )
            //右斜线width     640.0  768.0
            canvas?.drawLine(
                    width.toFloat() / 8 * 5,
                    height.toFloat() / 12 * 10,
                    width.toFloat() / 8 * 6,
                    height.toFloat() / 12 * 12,
                    mPaint
            )
            canvas?.drawLine(
                    width.toFloat() / 8 * 6,
                    height.toFloat() / 12 * 12,
                    width.toFloat() / 8 * 8 - 50,
                    height.toFloat() / 12 * 12,
                    mPaint
            )
            canvas?.drawText("1", (width / 10 * 4.5).toFloat(), height.toFloat() / 12 * 10 + 15, paint)
            canvas?.drawText("百立专用线", (width.toFloat() / 8 * 5.6).toFloat(), height.toFloat() / 12 * 12 - 10, paint)

            //平过道
            canvas?.drawLine(
                    (canvas.width / 8 * 2.1).toFloat(),
                    height.toFloat() / 12 * 1,
                    (canvas.width / 8 * 2.1).toFloat(),
                    height.toFloat() / 12 * 6,
                    paint1
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 2.3).toFloat(),
                    height.toFloat() / 12 * 1,
                    (canvas.width / 8 * 2.3).toFloat(),
                    height.toFloat() / 12 * 6,
                    paint1
            )
            canvas?.drawText(
                    "平",
                    (canvas.width / 8.4 * 2.15).toFloat(),
                    (height.toFloat() / 12 * 3 + 15).toFloat(),
                    paint1
            )
            canvas?.drawText(
                    "过",
                    (canvas.width / 8.4 * 2.15).toFloat(),
                    (height.toFloat() / 12 * 3.5 + 15).toFloat(),
                    paint1
            )
            canvas?.drawText(
                    "道",
                    (canvas.width / 8.4 * 2.15).toFloat(),
                    (height.toFloat() / 12 * 4 + 15).toFloat(),
                    paint1
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 5.3).toFloat(),
                    (height.toFloat() / 12 * 1.1).toFloat(),
                    (canvas.width / 8 * 5.3).toFloat(),
                    height.toFloat() / 12 * 6,
                    paint1
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 5.5).toFloat(),
                    (height.toFloat() / 12 * 1.1).toFloat(),
                    (canvas.width / 8 * 5.5).toFloat(),
                    height.toFloat() / 12 * 6,
                    paint1
            )
            canvas?.drawText(
                    "平",
                    (canvas.width / 8.1 * 5.35).toFloat(),
                    (height.toFloat() / 12 * 3 + 15).toFloat(),
                    paint1
            )
            canvas?.drawText(
                    "过",
                    (canvas.width / 8.1 * 5.35).toFloat(),
                    (height.toFloat() / 12 * 3.5 + 15).toFloat(),
                    paint1
            )
            canvas?.drawText(
                    "道",
                    (canvas.width / 8.1 * 5.35).toFloat(),
                    (height.toFloat() / 12 * 4 + 15).toFloat(),
                    paint1
            )
        }
    }
}