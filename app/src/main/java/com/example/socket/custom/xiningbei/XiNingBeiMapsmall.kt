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
class XiNingBeiMapsmall(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val beishu =1.2F
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
            it.textSize = 18F/beishu
            it.isDither = true
        }
    }
    private val paint1 by lazy {
        Paint().also {
            it.color = Color.parseColor("#70A6EE")
            it.style = Paint.Style.FILL
            it.isAntiAlias = true
            it.strokeWidth = 3F
            it.textSize = 18F/beishu
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
                    (canvas.width / 8 * 2.4/beishu).toFloat(),
                    height.toFloat() / 12 * 1/beishu,
                    canvas.width.toFloat() / 8 * 6/beishu,
                    height.toFloat() / 12 * 1/beishu,
                    mPaint
            )
            //左斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 2.4/beishu).toFloat(),
                    height.toFloat() / 12 * 1/beishu,
                    (canvas.width / 8 * 1.8/beishu).toFloat(),
                    height.toFloat() / 12 * 3/beishu,
                    mPaint
            )
            //右斜线
            canvas?.drawLine(
                    canvas.width / 8 * 5/beishu,
                    height.toFloat() / 12 * 1/beishu,
                    canvas.width.toFloat() / 8 * 6/beishu,
                    height.toFloat() / 12 * 3/beishu,
                    mPaint
            )
            canvas?.drawText("H3", (width / 10 * 4.5/beishu).toFloat(),
                (height.toFloat() / 12 * 1 + 15)/beishu, paint)
            //H2
            canvas?.drawLine(
                ((canvas.width / 8 * 1.6)/beishu).toFloat(),
                    height.toFloat() / 12 * 3/beishu,
                    canvas.width.toFloat() / 8 * 6/beishu,
                    height.toFloat() / 12 * 3/beishu,
                    mPaint
            )
            Log.e("qgs1", (canvas.width / 8 * 1.6/beishu).toFloat().toString())
            Log.e("qgs2", (height.toFloat() / 12 * 3/beishu).toString())
            //左斜线
            canvas?.drawLine(
                (canvas.width / 8 * 1.6/beishu).toFloat(), height.toFloat() / 12 * 3/beishu,
                    canvas.width / 8/beishu, height.toFloat() / 12 * 5/beishu, mPaint
            )
            Log.e("qgs4", (height.toFloat() / 12 * 5/beishu).toString())
            //右斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 6/beishu), height.toFloat() / 12 * 3/beishu, (canvas.width / 8 * 6.5/beishu).toFloat(),
                    (height.toFloat() / 12.5 * 6.5/beishu).toFloat(), mPaint
            )
            canvas?.drawText("H2", (width / 10 * 4.5/beishu).toFloat(),
                (height.toFloat() / 12 * 3 + 15)/beishu, paint)
            //H1
            canvas?.drawLine(
                    50F/beishu,
                    height.toFloat() / 12 * 5/beishu,
                    canvas.width.toFloat() / 8 * 6/beishu,
                    height.toFloat() / 12 * 5/beishu,
                    mPaint
            )
            Log.e("qgs3", (height.toFloat() / 12 * 5/beishu).toString())
            //右斜线
            canvas?.drawLine(
                    canvas.width.toFloat() / 8 * 6/beishu,
                    height.toFloat() / 12 * 5/beishu,
                    canvas.width.toFloat() / 8 * 7/beishu,
                    height.toFloat() / 12 * 8/beishu,
                    mPaint
            )
            canvas?.drawText("H1",
                ((width / 10 * 4.5)/beishu).toFloat(),
                (height.toFloat() / 12 * 5 + 15)/beishu, paint)
            //5
            canvas?.drawLine(
                    (canvas.width / 8 * 3)/beishu,
                    height.toFloat() / 12 * 6/beishu,
                    (canvas.width / 8 * 5)/beishu,
                    height.toFloat() / 12 * 6/beishu,
                    mPaint
            )
            //左斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 2)/beishu,
                    height.toFloat() / 12 * 8/beishu,
                    (canvas.width / 8 * 3)/beishu,
                    height.toFloat() / 12 * 6/beishu,
                    mPaint
            )
            canvas?.drawText("5",
                ((width / 10 * 4.5)/beishu).toFloat(),
                ((height.toFloat() / 12 * 6 + 15)/beishu), paint)
            //右斜线
            canvas?.drawLine(
                    (canvas.width / 8 * 5)/beishu,
                    height.toFloat() / 12 * 6/beishu,
                    (canvas.width / 8 * 6)/beishu,
                    height.toFloat() / 12 * 8/beishu,
                    mPaint
            )
            //4
            canvas?.drawLine(
                ((canvas.width / 8 * 2.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 7/beishu,
                ((canvas.width / 8 * 5.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 7/beishu,
                    mPaint
            )
            canvas?.drawText("4",
                ((width / 10 * 4.5)/beishu).toFloat(),
                ((height.toFloat() / 12 * 7 + 15)/beishu), paint)
            //III
            canvas?.drawLine(
                    (canvas.width / 8)/beishu,
                    height.toFloat() / 12 * 8/beishu,
                (canvas.width.toFloat() - 50)/beishu,
                    height.toFloat() / 12 * 8/beishu,
                    mPaint
            )
            //左斜线
            canvas?.drawLine(
                    50F,
                    height.toFloat() / 12 * 5/beishu,
                    (canvas.width / 8)/beishu.toFloat(),
                    height.toFloat() / 12 * 8/beishu,
                    mPaint
            )
            canvas?.drawLine(
                ((canvas.width / 8 * 1.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 8/beishu,
                    (canvas.width / 8 * 2)/beishu,
                    height.toFloat() / 12 * 9/beishu,
                    mPaint
            )
            canvas?.drawText("III",
                ((width / 10 * 4.5)/beishu).toFloat(),
                ((height.toFloat() / 12 * 8 + 15)/beishu), paint)
            //2
            canvas?.drawLine(
                    50F/beishu,
                    height.toFloat() / 12 * 9/beishu,
                    (canvas.width / 8 * 6)/beishu,//450
                    height.toFloat() / 12 * 9/beishu,//768
                    mPaint
            )
            //右斜线(canvas.width/8*6.5).toFloat()=832.0   (canvas.width/8*6).toFloat()=768.0
            //height.toFloat()/12*10=439.1667     height.toFloat()/12*9=395.25
            canvas?.drawLine(
                    (canvas.width / 8 * 6)/beishu, height.toFloat() / 12 * 9/beishu,
                ((canvas.width / 8 * 6.5)/beishu).toFloat(), height.toFloat() / 12 * 10/beishu, mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 7)/beishu,
                    height.toFloat() / 12 * 10/beishu,
                ((canvas.width / 8 * 7.2)/beishu).toFloat(),
                    height.toFloat() / 12 * 9/beishu,
                    mPaint
            )
            canvas?.drawLine(
                ((canvas.width / 8 * 7.2)/beishu).toFloat(), height.toFloat() / 12 * 9/beishu,
                    (canvas.width - 50)/beishu, height.toFloat() / 12 * 9/beishu, mPaint
            )
            canvas?.drawLine(
                ((canvas.width / 8 * 6.5)/beishu).toFloat(), height.toFloat() / 12 * 10/beishu,
                    (canvas.width - 50)/beishu, height.toFloat() / 12 * 10/beishu, mPaint
            )
            canvas?.drawLine(
                ((canvas.width / 8 * 6.7)/beishu).toFloat(), height.toFloat() / 12 * 10/beishu,
                    (canvas.width / 8 * 7)/beishu, height.toFloat() / 12 * 11/beishu, mPaint
            )
            canvas?.drawLine(
                    (canvas.width / 8 * 7)/beishu, height.toFloat() / 12 * 11/beishu,
                    (canvas.width - 50)/beishu, height.toFloat() / 12 * 11/beishu, mPaint
            )
            canvas?.drawText("2",
                ((width / 10 * 4.5)/beishu).toFloat(),
                (height.toFloat() / 12 * 9 + 15)/beishu, paint)
            canvas?.drawText("物1",
                ((canvas.width / 8 * 7.2)/beishu).toFloat(),
                (height.toFloat() / 12 * 9 + 15)/beishu, paint)
            canvas?.drawText("物2", (canvas.width / 8 * 7)/beishu,
                (height.toFloat() / 12 * 10 + 15)/beishu, paint)
            canvas?.drawText("物3", (canvas.width / 8 * 7)/beishu,
                (height.toFloat() / 12 * 11 + 15)/beishu, paint)
            //1
            canvas?.drawLine(
                    width.toFloat() / 8 * 3/beishu,
                    height.toFloat() / 12 * 10/beishu,
                    width.toFloat() / 8 * 5/beishu,
                    height.toFloat() / 12 * 10/beishu,
                    mPaint
            )
            //左斜线 width 384.0    320.0
            canvas?.drawLine(
                    width.toFloat() / 8 * 3/beishu,
                    height.toFloat() / 12 * 10/beishu,
                ((width.toFloat() / 8 * 2.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 9/beishu,
                    mPaint
            )
            //长丰专用线    192.0
            canvas?.drawLine(
                    50F,
                    height.toFloat() / 12 * 10/beishu,
                ((width.toFloat() / 8 * 1.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 10/beishu,
                    mPaint
            )
            canvas?.drawText("长丰专用线", (width.toFloat() / 8)/beishu,
                ((height.toFloat() / 12 * 10 + 15)/beishu), paint)
            //1道中间  width ((width.toFloat()/8*1.5).toFloat() = 192.0     width.toFloat()/8*12 = 256.0)
            canvas?.drawLine(
                ((width.toFloat() / 8 * 1.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 9/beishu,
                    width.toFloat() / 8 * 2/beishu,
                    height.toFloat() / 12 * 10/beishu,
                    mPaint
            )
            //(width.toFloat()/8*2.5).toFloat() = 256.0
            canvas?.drawLine(
                    width.toFloat() / 8 * 2/beishu,
                    height.toFloat() / 12 * 10/beishu,
                ((width.toFloat() / 8 * 2.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 10/beishu,
                    mPaint
            )
            //(width.toFloat()/8*1.5).toFloat() = 192.0    (width.toFloat()/8*1.3).toFloat() = 166.4
            canvas?.drawLine(
                ((width.toFloat() / 8 * 1.3)/beishu).toFloat(),
                    height.toFloat() / 12 * 9/beishu,
                    width.toFloat() / 8/beishu,
                    height.toFloat() / 12 * 10/beishu,
                    mPaint
            )
            //右斜线width     640.0  768.0
            canvas?.drawLine(
                    width.toFloat() / 8 * 5/beishu,
                    height.toFloat() / 12 * 10/beishu,
                    width.toFloat() / 8 * 6/beishu,
                    height.toFloat() / 12 * 12/beishu,
                    mPaint
            )
            canvas?.drawLine(
                    width.toFloat() / 8 * 6/beishu,
                    height.toFloat() / 12 * 12/beishu,
                (width.toFloat() / 8 * 8 - 50)/beishu,
                    height.toFloat() / 12 * 12/beishu,
                    mPaint
            )
            canvas?.drawText("1",
                ((width / 10 * 4.5)/beishu).toFloat(),
                (height.toFloat() / 12 * 10 + 15)/beishu, paint)
            canvas?.drawText("百立专用线", ((width.toFloat() / 8 * 6.5)/beishu).toFloat(),
                (height.toFloat() + 20)/beishu, paint)

            //平过道
            canvas?.drawLine(
                ((canvas.width / 8 * 2.1)/beishu).toFloat(),
                    height.toFloat() / 12 * 1/beishu,
                ((canvas.width / 8 * 2.1)/beishu).toFloat(),
                    height.toFloat() / 12 * 6/beishu,
                    paint1
            )
            canvas?.drawLine(
                ((canvas.width / 8 * 2.3)/beishu).toFloat(),
                    height.toFloat() / 12 * 1/beishu,
                ((canvas.width / 8 * 2.3)/beishu).toFloat(),
                    height.toFloat() / 12 * 6/beishu,
                    paint1
            )
//            canvas?.drawText(
//                    "平",
//                ((canvas.width / 8 * 2.15)/beishu).toFloat(),
//                    (height.toFloat() / 12 * 3 + 15)/beishu,
//                    paint1
//            )
//            canvas?.drawText(
//                    "过",
//                ((canvas.width / 8 * 2.15)/beishu).toFloat(),
//                ((height.toFloat() / 12 * 3.5 + 15)/beishu).toFloat(),
//                    paint1
//            )
//            canvas?.drawText(
//                    "道",
//                ((canvas.width / 8 * 2.15)/beishu).toFloat(),
//                    (height.toFloat() / 12 * 4 + 15)/beishu,
//                    paint1
//            )
            canvas?.drawLine(
                ((canvas.width / 8 * 5.3)/beishu).toFloat(),
                ((height.toFloat() / 12 * 1.1)/beishu).toFloat(),
                ((canvas.width / 8 * 5.3)/beishu).toFloat(),
                    height.toFloat() / 12 * 6/beishu,
                    paint1
            )
            canvas?.drawLine(
                ((canvas.width / 8 * 5.5)/beishu).toFloat(),
                ((height.toFloat() / 12 * 1.1)/beishu).toFloat(),
                ((canvas.width / 8 * 5.5)/beishu).toFloat(),
                    height.toFloat() / 12 * 6/beishu,
                    paint1
            )
//            canvas?.drawText(
//                    "平",
//                ((canvas.width / 8 * 5.35)/beishu).toFloat(),
//                    (height.toFloat() / 12 * 3 + 15)/beishu,
//                    paint1
//            )
//            canvas?.drawText(
//                    "过",
//                ((canvas.width / 8 * 5.35)/beishu).toFloat(),
//                ((height.toFloat() / 12 * 3.5 + 15)/beishu).toFloat(),
//                    paint1
//            )
//            canvas?.drawText(
//                    "道",
//                ((canvas.width / 8 * 5.35)/beishu).toFloat(),
//                    (height.toFloat() / 12 * 4 + 15)/beishu,
//                    paint1
//            )
        }
    }
}