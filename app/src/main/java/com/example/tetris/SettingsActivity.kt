package com.example.tetris

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {
    val close = closeReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        MediaPlayerManager("play")

        musicsettings()

        btn(R.id.btnGest)
        btn(R.id.btnOnOff)
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

    fun musicsettings(){
        var sb: SeekBar;
        var editor: SharedPreferences;

        editor = getSharedPreferences("settings", Context.MODE_PRIVATE);

        var value: Int;
        value = 100;
        if(editor.contains("sound"))
            value = editor.getInt("sound", 100);
        else Toast.makeText(this, "ohladi svoe trahanie", Toast.LENGTH_SHORT);

        sb = findViewById<SeekBar>(R.id.soundbar);

        var audioManager: AudioManager =
            (getSystemService(AUDIO_SERVICE) as AudioManager);
        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        val curValue = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        sb.setMax(maxVolume)
        sb?.setProgress(curValue);

        sb?.setProgress(value, true);

        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, value, 0);

        sb?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                val ed = editor?.edit();
                ed?.putInt("sound", sb.getProgress())
                ed?.apply()
                Toast.makeText(this@SettingsActivity,
                    sb.getProgress().toString(),
                    Toast.LENGTH_SHORT).show();
            }
        })
    }

    fun btn(btns: Int){
        var editor: SharedPreferences;
        editor = getSharedPreferences("settings", Context.MODE_PRIVATE);

        var btns:Switch = findViewById(btns);
        var value = true;
        var str: String;
        if(btns.getText() == "Gestures")
            str = "gest";
        else str = "btns"

        if(editor.contains(str))
            value = editor.getBoolean(str, true);

        btns.setChecked(value);

        btns.setOnCheckedChangeListener { _, isChecked ->
            val ed = editor?.edit()
            Toast.makeText(this@SettingsActivity, "ne poniatno", Toast.LENGTH_SHORT);
            if(isChecked)
                ed?.putBoolean(str, true)
            else
                ed?.putBoolean(str, false)
            ed?.apply()
        }
    }
}