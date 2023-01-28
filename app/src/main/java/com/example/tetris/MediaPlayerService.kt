package com.example.tetris

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.os.IBinder
import androidx.annotation.Nullable


class MediaPlayerService : Service(), OnCompletionListener {
    private var mMediaPlayer: MediaPlayer? = null
    override fun onCreate() {
        super.onCreate()
        mMediaPlayer = MediaPlayer();
//        mMediaPlayer!!.setDataSource(this, Uri);
        mMediaPlayer!!.setOnCompletionListener(this)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val action = intent.action
        val title = intent.getStringExtra("title")
        val resID = resources.getIdentifier(title, "raw", packageName)
        if (action != null) {
            when (action) {
                "play" -> {
                    mMediaPlayer!!.setDataSource(
                        applicationContext,
                        Uri.parse("android.resource://$packageName/$resID")
                    );
                    mMediaPlayer!!.prepare();
                    mMediaPlayer!!.start();
                }
                "pause" -> {
                    if(mMediaPlayer!!.isPlaying()) mMediaPlayer!!.pause()
                }
                "stop" -> {
                    if(mMediaPlayer!!.isPlaying()) mMediaPlayer!!.stop()
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCompletion(mp: MediaPlayer) {
        mMediaPlayer!!.seekTo(0)
        mMediaPlayer!!.prepare()
        mMediaPlayer!!.start()
    }

    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}