package com.example.flight_android_app

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity



 class MainActivity : AppCompatActivity(R.layout.activity_main), SeekBar.OnSeekBarChangeListener {

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

     override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
         TODO("Not yet implemented")
     }
 }

/*
class MainActivity : AppCompatActivity() {
    var ip: EditText? = null
    var port: EditText? = null
    var port_erase: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        ip = findViewById(R.id.ip)
        port = findViewById(R.id.port)
        setContentView(R.layout.activity_main)

        val seek = findViewById<SeekBar>(R.id.throttle)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(this@MainActivity,
                    "Progress is: " + seek.progress + "%",
                    Toast.LENGTH_SHORT).show()
            }
        })
    }
}*/
