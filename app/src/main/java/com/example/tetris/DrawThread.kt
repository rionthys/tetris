package com.example.tetris

import android.content.res.Resources
import android.graphics.*
import android.view.SurfaceHolder
import android.view.ViewGroup


internal class DrawThread(private val surfaceHolder: SurfaceHolder, resources: Resources?) :
    Thread() {
    private var runFlag = false
    private val picture: Bitmap
    private val matrix: Matrix
    private var prevTime: Long

    init {


        // загружаем картинку, которую будем отрисовывать
        picture = BitmapFactory.decodeResource(resources, R.drawable.line)

        // формируем матрицу преобразований для картинки
        matrix = Matrix()
        matrix.postScale(3.0f, 3.0f)
        matrix.postTranslate(100.0f, 100.0f)

        // сохраняем текущее время
        prevTime = System.currentTimeMillis()
    }

    fun setRunning(run: Boolean) {
        runFlag = run
    }

    override fun run() {
        var canvas: Canvas?
        while (runFlag) {
            // получаем текущее время и вычисляем разницу с предыдущим
            // сохраненным моментом времени
            val now = System.currentTimeMillis()
            val elapsedTime = now - prevTime
            if (elapsedTime > 30) {
                // если прошло больше 30 миллисекунд - сохраним текущее время
                // и повернем картинку на 2 градуса.
                // точка вращения - центр картинки
                prevTime = now
                matrix.preRotate(2.0f, (picture.width / 2).toFloat(), (picture.width / 2).toFloat())
            }
            canvas = null
            try {
                // получаем объект Canvas и выполняем отрисовку
                canvas = surfaceHolder.lockCanvas(null)
                synchronized(surfaceHolder) {
                    canvas.drawColor(Color.BLACK)
                    canvas.drawBitmap(picture, matrix, null)
                }
            } finally {
                if (canvas != null) {
                    // отрисовка выполнена. выводим результат на экран
                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }
        }
    }
}