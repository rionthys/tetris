package com.example.tetris

import TetrisView
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MediaPlayerManager("play")

        val surfaceView = MySurfaceView(this)
        val layout = findViewById<ConstraintLayout>(R.id.tetrislayout)
        layout.addView(surfaceView)
        val constraintSet = ConstraintSet()
        constraintSet.clone(layout)
        constraintSet.connect(surfaceView.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP, 0)
        constraintSet.connect(surfaceView.id, ConstraintSet.LEFT, layout.id, ConstraintSet.LEFT, 0)
        constraintSet.connect(surfaceView.id, ConstraintSet.RIGHT, layout.id, ConstraintSet.RIGHT, 0)
        constraintSet.connect(surfaceView.id, ConstraintSet.BOTTOM, layout.id, ConstraintSet.BOTTOM, 0)
        constraintSet.applyTo(layout)
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