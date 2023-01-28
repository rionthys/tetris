package com.example.tetris

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.ViewGroup


class MySurfaceView(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {
    private var drawThread: DrawThread? = null

    init {
        layoutParams = ViewGroup.LayoutParams(
            600,
            800
        )
        setWillNotDraw(false)
        holder.addCallback(this)
    }

    override fun surfaceChanged(
        holder: SurfaceHolder, format: Int, width: Int,
        height: Int
    ) {
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        drawThread = DrawThread(getHolder(), resources)
        drawThread!!.setRunning(true)
        drawThread!!.start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        var retry = true
        // завершаем работу потока
        drawThread!!.setRunning(false)
        while (retry) {
            try {
                drawThread!!.join()
                retry = false
            } catch (e: InterruptedException) {
                // если не получилось, то будем пытаться еще и еще
            }
        }
    }
}