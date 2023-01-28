package com.example.tetris


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MediaPlayerManager("play")
    }

    fun MediaPlayerManager(action: String){
        val intent = Intent(this, MediaPlayerService::class.java)
        intent.action = action
        intent.putExtra("title", "title.mp3");
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

    public fun play(v: View)
    {
        when (v.getId()) {
            R.id.button -> {
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
            }
            else -> {
                Toast.makeText(applicationContext, "sto??", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public fun setting(v: View)
    {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}