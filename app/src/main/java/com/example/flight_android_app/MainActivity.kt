package com.example.flight_android_app
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.jackandphantom.joystickview.JoyStickView
import model.Model




/*class com.example.flight_android_app.MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/


class MainActivity : AppCompatActivity() {
    var ip: EditText? = null
    var port: EditText? = null
    var port_erase: EditText? = null
    val model = Model()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var joyStick : JoyStick = JoyStick(findViewById<JoyStickView>(R.id.joy))

        val joyStickView = findViewById<JoyStickView>(R.id.joy)
        joyStickView.setOnMoveListener(object : JoyStickView.OnMoveListener {
            fun onMove(angle: Int, strength: Int) {
            }
            override fun onMove(angle: Double, strength: Float) {
                joyStick.setMove(angle, strength)
            }
        })

        val throttleSeek = findViewById<SeekBar>(R.id.throttleSeek)
        throttleSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                model.throttle = progress.toFloat()/1000
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })
        val rudderSeek = findViewById<SeekBar>(R.id.rudderSeek)
        rudderSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                model.rudder = progress.toFloat()/1000
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })

    }
}
