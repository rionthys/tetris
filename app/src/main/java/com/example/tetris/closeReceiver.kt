package com.example.tetris

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class closeReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
//        if (p1?.action == Intent.ACTION_CLOSE_SYSTEM_DIALOGS || p1?.action == Intent.ACTION_SCREEN_OFF || p1?.action == Intent.ACTION_SHUTDOWN) {
//            MainActivity.mPlayer!!.pause()
//        }
//       if(p1?.action == Intent.CATEGORY_LAUNCHER){
//           MainActivity.mPlayer!!.start()
//        }
    }

    private fun startPlay() {
//        MainActivity.mPlayer!!.start()
    }
}