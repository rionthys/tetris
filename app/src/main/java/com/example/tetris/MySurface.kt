package com.example.tetris

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView


class MySurface(context: Context?, attrs: AttributeSet?) :
    SurfaceView(context, attrs), SurfaceHolder.Callback {
    private var image: Bitmap? = null
    private val surfaceHolder: SurfaceHolder

    init {
        surfaceHolder = holder
        surfaceHolder.addCallback(this)
    }

    fun setImage(image: Bitmap?) {
        this.image = image
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        val canvas = holder.lockCanvas()
        if (canvas != null && image != null) {
            canvas.drawBitmap(image!!, 0f, 0f, null)
        }
        holder.unlockCanvasAndPost(canvas)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // not needed in this example
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // not needed in this example
    }
}
