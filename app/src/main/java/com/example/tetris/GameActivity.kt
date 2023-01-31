package com.example.tetris

import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {
    var surfaceView: MySurface? = null;
    var canvas: Canvas? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game);
        MediaPlayerManager("play")
        val sf = findViewById<SurfaceView>(R.id.surface_view)
        sf.holder.addCallback(object: SurfaceHolder.Callback {
            var drawThread: DrawThread? = null;
            override fun surfaceCreated(p0: SurfaceHolder) {
                canvas = p0.lockCanvas(null)
                canvas!!.drawColor(Color.BLACK)
                background()
                val rand = (1..7).random()
                when (rand) {
                    1 -> CreateT()
                    2 -> CreateS()
                    3 -> CreateL()
                    4 -> CreateZ()
                    5 -> CreateI()
                    6 -> CreateO()
                    7 -> CreateJ()
                }
                p0.unlockCanvasAndPost(canvas)
            }

            override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

            }

            override fun surfaceDestroyed(p0: SurfaceHolder) {
//                var retry = true
//                // завершаем работу потока
//                // завершаем работу потока
//                drawThread?.setRunning(false)
//                while (retry) {
//                    try {
//                        drawThread?.join()
//                        retry = false
//                    } catch (e: InterruptedException) {
//                        // если не получилось, то будем пытаться еще и еще
//                    }
//                }
            }
        })

    }

    fun background(){
        val paint = Paint()
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        paint.setColor(Color.GRAY)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(3f);
        for(i in 0..9){
            if(i % 2 == 0) {
                path.lineTo(i * value.toFloat(), 20 * value.toFloat())
                path.lineTo((i + 1) * value.toFloat(), 20 * value.toFloat())
            }
            else {
                path.lineTo(i * value.toFloat(),0f)
                path.lineTo( (i + 1) * value.toFloat(), 0f)
            }
        }
        for(i in 0..19){
            if(i % 2 == 0) {
                path.lineTo(10 * value.toFloat(), i * value.toFloat())
                path.lineTo(10 * value.toFloat(), (i + 1) * value.toFloat())
            }
            else {
                path.lineTo(0f, i * value.toFloat())
                path.lineTo( 0f, (i+1) * value.toFloat())
            }
        }
        path.moveTo(0f, 0f)
        path.lineTo(0f, 20*value.toFloat())
        path.lineTo(10*value.toFloat(), 20*value.toFloat())
        path.lineTo(10*value.toFloat(), 0*value.toFloat())
        path.lineTo(0*value.toFloat(), 0*value.toFloat())
        canvas!!.drawPath(path, paint)
    }
    fun CreateI(){
        val paint = Paint()
        paint.setColor(Color.CYAN)
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        path.moveTo(3 * value.toFloat(), 0f)
        path.lineTo(7 * value.toFloat(), 0f)
        path.lineTo(7 * value.toFloat(), value.toFloat())
        path.lineTo(3 * value.toFloat(), value.toFloat())
        path.lineTo(3 * value.toFloat(), 0f)

        canvas!!.drawPath(path, paint)
        paint.setColor(Color.WHITE)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(5f);

        path.lineTo(7 * value.toFloat(), 0f)
        path.lineTo(7 * value.toFloat(), value.toFloat())
        path.lineTo(3 * value.toFloat(), value.toFloat())
        path.lineTo(3 * value.toFloat(), 0f)
        path.lineTo(4 * value.toFloat(), 0f)
        path.lineTo(4 * value.toFloat(), value.toFloat())
        path.lineTo(5 * value.toFloat(), value.toFloat())
        path.lineTo(5 * value.toFloat(), 0f)
        path.lineTo(6 * value.toFloat(), 0f)
        path.lineTo(6 * value.toFloat(), value.toFloat())

        canvas!!.drawPath(path, paint)
    }

    fun CreateL(){
        val paint = Paint()
        paint.setColor(Color.parseColor("#FFA500"))
        paint.setStyle(Paint.Style.FILL)
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        path.moveTo(6 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 0 * value.toFloat())

        canvas!!.drawPath(path, paint)
        paint.setColor(Color.WHITE)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(5f);

        path.moveTo(6 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())


        canvas!!.drawPath(path, paint)
    }

    fun CreateS(){
        val paint = Paint()
        paint.setColor(Color.GREEN)
        paint.setStyle(Paint.Style.FILL)
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        path.moveTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())

        canvas!!.drawPath(path, paint)
        paint.setColor(Color.WHITE)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(5f);


        path.moveTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())

        canvas!!.drawPath(path, paint)
    }

    fun CreateZ(){
        val paint = Paint()
        paint.setColor(Color.RED)
        paint.setStyle(Paint.Style.FILL)
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        path.moveTo(3 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 0 * value.toFloat())

        canvas!!.drawPath(path, paint)
        paint.setColor(Color.WHITE)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(5f);


        path.moveTo(3 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())

        canvas!!.drawPath(path, paint)
    }

    fun CreateT(){
        val paint = Paint()
        paint.setColor(Color.parseColor("#00008B"))
        paint.setStyle(Paint.Style.FILL)
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        path.moveTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())

        canvas!!.drawPath(path, paint)
        paint.setColor(Color.WHITE)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(5f);

        path.moveTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())


        canvas!!.drawPath(path, paint)
    }

    fun CreateJ(){
        val paint = Paint()
        paint.setColor(Color.parseColor("#FFA500"))
        paint.setStyle(Paint.Style.FILL)
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        path.moveTo(3 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 0 * value.toFloat())

        canvas!!.drawPath(path, paint)
        paint.setColor(Color.WHITE)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(5f);

        path.moveTo(3 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(6 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 0 * value.toFloat())
        path.lineTo(3 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 1 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(5 * value.toFloat(), 1 * value.toFloat())


        canvas!!.drawPath(path, paint)
    }

    fun CreateO(){
        val paint = Paint()
        paint.setColor(Color.YELLOW)
        val surf = findViewById<SurfaceView>(R.id.surface_view)
        val value = surf.width/10;
        val path = Path();
        path.moveTo(4 * value.toFloat(), 0f)
        path.lineTo(6 * value.toFloat(), 0f)
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0f)

        canvas!!.drawPath(path, paint)
        paint.setColor(Color.WHITE)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(5f);

        path.lineTo(6 * value.toFloat(), 0f)
        path.lineTo(6 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(4 * value.toFloat(), 0f)

        path.lineTo(5 * value.toFloat(), 0f)
        path.lineTo(5 * value.toFloat(), 2 * value.toFloat())
        path.lineTo(6 * value.toFloat(),  2 * value.toFloat())
        path.lineTo(6 * value.toFloat(), value.toFloat())
        path.lineTo(4 * value.toFloat(), value.toFloat())

        canvas!!.drawPath(path, paint)
    }

    fun MediaPlayerManager(action: String){
        val intent = Intent(this, MediaPlayerService::class.java)
        intent.action = action
        startService(intent)
    }

    override fun onResume(){
        super.onResume();
        MediaPlayerManager("play")
    }
    override fun onPause(){
        super.onPause();
        MediaPlayerManager("pause")
    }
    override fun onDestroy(){
        super.onDestroy();
        MediaPlayerManager("stop")
    }
}


